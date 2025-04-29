async function registerFeeding() {
    return new Promise(async (resolve, reject) => {
        const feeding = document.getElementById("feeding").value.trim();

        // Validación
        if (!feeding) {
            alert("El campo alimentación es obligatorio.");
            return reject("Campo vacío");
        }

        if (feeding.length > 50) {
            alert("El nombre de la alimentación no puede superar los 50 caracteres.");
            return reject("Nombre demasiado largo");
        }

        try {
            // Obtener todas las alimentaciones para verificar si ya existe
            const existingResponse = await fetch("http://localhost:8080/feeding/", {
                method: "GET",
                headers: {
                    "Accept": "*/*",
                    "Content-Type": "application/json"
                }
            });

            if (!existingResponse.ok) throw new Error("No se pudieron obtener las alimentaciones");

            const existingFeedings = await existingResponse.json();
            const exists = existingFeedings.some(f => f.nameFeeding.toLowerCase() === feeding.toLowerCase());

            if (exists) {
                alert("La alimentación ya está registrada.");
                return reject("Alimentación duplicada");
            }

            // Si no existe, la registramos
            const headers = {
                "Accept": "*/*",
                "User-Agent": "web",
                "Content-Type": "application/json"
            };

            const bodyContent = JSON.stringify({ "nameFeeding": feeding });

            const response = await fetch("http://localhost:8080/feeding/", {
                method: "POST",
                body: bodyContent,
                headers: headers
            });

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(errorText || "Error al registrar la alimentación.");
            }

            const data = await response.text();
            console.log(data);

            window.location.href = "index-feeding.html";
            resolve();
        } catch (error) {
            console.error("Error:", error);
            alert("No se pudo registrar la alimentación: " + error.message);
            reject(error);
        }
    });
}

function getFeedings() {
    return new Promise(async (resolve) => {
        let url = "http://localhost:8080/feeding/";
        let filtro = document.getElementById("feedingNameFilter")?.value;

        if (filtro && filtro !== "") {
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

            if (!response.ok) {
                throw new Error("Error al obtener datos");
            }

            let data = await response.json();

            // Limpiar lista
            let container = document.getElementById("feedingList");
            if (!container) {
                console.error("No se encontró el elemento #feedingList");
                return;
            }

            container.innerHTML = "";

            data.forEach(feeding => {
                let col = document.createElement("div");
                col.className = "col-lg-3 col-md-5 mb-4";

                let card = document.createElement("div");
                card.className = "card shadow p-3 h-100 d-flex fex-column";

                let title = document.createElement("h5");
                title.innerText = feeding.nameFeeding;
                title.className = "text-center";

                let btnContainer = document.createElement("div");
                btnContainer.className = "mt-auto d-flex justify-content-center";

                let btnEdit = document.createElement("button");
                btnEdit.className = "btn btn-sm btn-primary me-2";
                btnEdit.innerHTML = `<i class="bi bi-pencil"></i>`;
                btnEdit.addEventListener("click", function () {
                    showEditFeedingModal(feeding.feedingID, feeding.nameFeeding);
                });

                let btnDelete = document.createElement("button");
                btnDelete.className = "btn btn-sm btn-danger";
                btnDelete.innerHTML = `<i class="bi bi-trash"></i>`;
                btnDelete.addEventListener("click", function () {
                    deleteFeeding(feeding.feedingID);
                });

                btnContainer.appendChild(btnEdit);
                btnContainer.appendChild(btnDelete);

                card.appendChild(title);
                card.appendChild(btnContainer);

                col.appendChild(card);
                container.appendChild(col);
            });

            resolve();
        } catch (err) {
            console.error("Error al cargar alimentación:", err);
        }
    });
}


function showEditFeedingModal(id, name) {
    console.log("ID recibido para editar:", id);

    document.getElementById('editFeedingId').value = id;
    document.getElementById('editFeedingName').value = name;
    document.getElementById('editFeedingError').classList.add("d-none");

    const modal = new bootstrap.Modal(document.getElementById('editFeedingModal'));
    modal.show();
}


async function updateFeeding() {
    const id = document.getElementById('editFeedingId').value;
    const name = document.getElementById('editFeedingName').value.trim();

    if (!name) {
        document.getElementById('editFeedingError').classList.remove("d-none");
        return;
    }

    const headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
    };

    const bodyContent = JSON.stringify({
        nameFeeding: name
    });

    try {
        const response = await fetch(`http://localhost:8080/feeding/${id}`, {
            method: "PUT",
            body: bodyContent,
            headers: headersList
        });

        if (!response.ok) throw new Error("Error al actualizar");

        const modalElement = bootstrap.Modal.getInstance(document.getElementById('editFeedingModal'));
        modalElement.hide();

        getFeedings(); // Recarga la lista
    } catch (err) {
        alert("No se pudo actualizar la alimentación.");
        console.error(err);
    }
}

function deleteFeeding(id) {
    if (!confirm("¿Estás seguro de que deseas eliminar esta alimentación?")) return;

    fetch(`http://localhost:8080/feeding/${id}`, {
        method: "DELETE",
        headers: {
            "Accept": "*/*",
            "User-Agent": "web",
            "Content-Type": "application/json"
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("No se pudo eliminar la alimentación.");
        }
        return response.text();
    })
    .then(result => {
        console.log("Alimentación eliminada:", result);
        getFeedings(); // Recargar lista después de eliminar
    })
    .catch(error => {
        console.error("Error al eliminar:", error);
        alert("Ocurrió un error al intentar eliminar la alimentación.");
    });
}

