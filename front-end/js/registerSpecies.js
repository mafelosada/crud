function registerSpecies() {
    return new Promise(async (resolve, reject) => {
        const name = document.getElementById("nameSpecies").value.trim();
        const description = document.getElementById("description").value.trim();

        // Validaciones iniciales
        if (!name || !description) {
            alert("Todos los campos son obligatorios.");
            return reject("Campos vacíos");
        }

        if (name.length > 50) {
            alert("El nombre no puede superar los 50 caracteres.");
            return reject("Nombre demasiado largo");
        }

        try {
            // Validar si ya existe una especie con el mismo nombre
            const checkResponse = await fetch("http://localhost:8080/species/", {
                method: "GET",
                headers: {
                    "Accept": "*/*",
                    "Content-Type": "application/json"
                }
            });

            if (!checkResponse.ok) {
                throw new Error("Error al verificar duplicados.");
            }

            const speciesList = await checkResponse.json();

            const exists = speciesList.some(s => s.nameSpecies.toLowerCase() === name.toLowerCase());

            if (exists) {
                alert("Ya existe una especie con ese nombre.");
                return reject("Nombre duplicado");
            }

            // Si no existe, continuar con el registro
            const headersList = {
                "Accept": "*/*",
                "User-Agent": "web",
                "Content-Type": "application/json"
            };

            const bodyContent = JSON.stringify({
                "nameSpecies": name,
                "description": description
            });

            const response = await fetch("http://localhost:8080/species/", {
                method: "POST",
                body: bodyContent,
                headers: headersList
            });

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(errorText || "Error al registrar la especie.");
            }

            const data = await response.text();
            console.log(data);

            window.location.href = "index-species.html";
            resolve();
        } catch (error) {
            console.error("Error:", error);
            alert("No se pudo registrar la especie: " + error.message);
            reject(error);
        }
    });
}
function getSpecies() {
    return new Promise(async (resolve) => {
        let url = "http://localhost:8080/species/";
        let filtro = document.getElementById("nameFilter").value.trim();

        if (filtro !== "") {
            url += "filter/" + filtro;
        }

        let headersList = {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        };

        try {
            let response = await fetch(url, {
                method: "GET",
                headers: headersList
            });

            if (!response.ok) throw new Error("No se pudo obtener la lista de especies");

            let data = await response.json();

            // Limpiar lista
            let container = document.getElementById("speciesList");
            container.innerHTML = "";

            data.forEach(specie => {
                // Columna
                let col = document.createElement("div");
                col.className = "col-lg-4 col-md-6 mb-3";

                // Card con altura completa y flex
                let card = document.createElement("div");
                card.className = "card shadow p-3 h-100 d-flex flex-column text-center";

                let title = document.createElement("h5");
                title.innerText = specie.nameSpecies;

                let desc = document.createElement("p");
                desc.innerText = specie.description;

                // Contenedor de botones al fondo
                let btnContainer = document.createElement("div");
                btnContainer.className = "mt-auto d-flex justify-content-center";

                let btnEdit = document.createElement("button");
                btnEdit.className = "btn btn-sm btn-primary me-2";
                btnEdit.innerHTML = `<i class="bi bi-pencil"></i>`;
                btnEdit.addEventListener("click", function () {
                    showEditModal(specie.speciesID, specie.nameSpecies, specie.description);
                });

                let btnDelete = document.createElement("button");
                btnDelete.className = "btn btn-sm btn-danger";
                btnDelete.innerHTML = `<i class="bi bi-trash"></i>`;
                btnDelete.addEventListener("click", function () {
                    deleteSpecies(specie.speciesID);
                });

                btnContainer.appendChild(btnEdit);
                btnContainer.appendChild(btnDelete);

                card.appendChild(title);
                card.appendChild(desc);
                card.appendChild(btnContainer);

                col.appendChild(card);
                container.appendChild(col);
            });

            resolve();
        } catch (error) {
            console.error("Error al cargar especies:", error);
            alert("Hubo un problema al cargar las especies.");
            resolve();
        }
    });
}


function showEditModal(id, name, description) {
    console.log("ID recibido:", id); // Verifica este valor
    document.getElementById('editSpeciesId').value = id;
    document.getElementById('editSpeciesName').value = name;
    document.getElementById('editSpeciesDescription').value = description;
    document.getElementById('editError').classList.add("d-none");

    let modal = new bootstrap.Modal(document.getElementById('editSpeciesModal'));
    modal.show();
}


async function updateSpecies() {
    const id = document.getElementById('editSpeciesId').value;
    const name = document.getElementById('editSpeciesName').value.trim();
    const description = document.getElementById('editSpeciesDescription').value.trim();

    if (!name || !description) {
        document.getElementById('editError').classList.remove("d-none");
        return;
    }

    const headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    };

    const bodyContent = JSON.stringify({
        nameSpecies: name,
        description: description
    });

    try {
        const response = await fetch(`http://localhost:8080/species/${id}`, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) throw new Error("Error al actualizar");

        // Cerrar el modal
        const modalElement = bootstrap.Modal.getInstance(document.getElementById('editSpeciesModal'));
        modalElement.hide();

        // Recargar la lista
        getSpecies();
    } catch (err) {
        alert("No se pudo actualizar la especie.");
        console.error(err);
    }
}



function deleteSpecies(id) {
    if (!confirm("¿Estás seguro de que deseas eliminar esta especie?")) return;

    fetch(`http://localhost:8080/species/${id}`, {
        method: "DELETE",
        headers: {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("No se pudo eliminar la especie.");
        }
        return response.text();
    })
    .then(result => {
        console.log("Especie eliminada:", result);
        getSpecies(); // Recargar lista después de eliminar
    })
    .catch(error => {
        console.error("Error al eliminar:", error);
        alert("Ocurrió un error al intentar eliminar la especie.");
    });
}

