function registerKeeper() {
    return new Promise(async (resolve, reject) => {
        const name = document.getElementById("nameKeeper").value.trim();
        const phone = document.getElementById("phone").value.trim();
        const specialty = document.getElementById("specialty").value.trim();

        // Validaciones iniciales
        if (!name || !phone || !specialty) {
            alert("Todos los campos son obligatorios.");
            return reject("Campos vacíos");
        }

        if (name.length > 50) {
            alert("El nombre no puede superar los 50 caracteres.");
            return reject("Nombre demasiado largo");
        }

        try {
            // Validar si ya existe un keeper con el mismo nombre
            const checkResponse = await fetch("http://localhost:8080/keeper/", {
                method: "GET",
                headers: {
                    "Accept": "*/*",
                    "Content-Type": "application/json"
                }
            });

            if (!checkResponse.ok) {
                throw new Error("Error al verificar duplicados.");
            }

            const keeperList = await checkResponse.json();

            const exists = keeperList.some(k => k.nameKeeper.toLowerCase() === name.toLowerCase());

            if (exists) {
                alert("Ya existe un cuidador con ese nombre.");
                return reject("Nombre duplicado");
            }

            // Si no existe, continuar con el registro
            const headersList = {
                "Accept": "*/*",
                "User-Agent": "web",
                "Content-Type": "application/json"
            };

            const bodyContent = JSON.stringify({
                "nameKeeper": name,
                "phone": phone,
                "specialty": specialty
            });

            const response = await fetch("http://localhost:8080/keeper/", {
                method: "POST",
                body: bodyContent,
                headers: headersList
            });

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(errorText || "Error al registrar el cuidador.");
            }

            const data = await response.text();
            console.log(data);

            window.location.href = "index-keeper.html";
            resolve();
        } catch (error) {
            console.error("Error:", error);
            alert("No se pudo registrar el cuidador: " + error.message);
            reject(error);
        }
    });
}
function getKeepers() {
    return new Promise(async (resolve) => {
        let url = "http://localhost:8080/keeper/";
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

            if (!response.ok) throw new Error("No se pudo obtener la lista de keepers");

            let data = await response.json();

            let container = document.getElementById("keeperList");
            container.innerHTML = ""; // Limpiar contenido anterior

            data.forEach((keeper) => {
                let card = document.createElement("div");
                card.className = "card mb-3 shadow-sm";
                card.innerHTML = `
                    <div class="card-body row align-items-center">
                        <div class="col-md-3"><strong>${keeper.nameKeeper}</strong></div>
                        <div class="col-md-3">${keeper.phone}</div>
                        <div class="col-md-4">${keeper.specialty}</div>
                        <div class="col-md-2 text-end">
                            <button class="btn btn-sm btn-primary me-1" onclick="showEditKeeperModal('${keeper.keeperID}', '${keeper.nameKeeper}', '${keeper.phone}', '${keeper.specialty}')">
                                <i class="bi bi-pencil"></i>
                            </button>
                            <button class="btn btn-sm btn-danger" onclick="deleteKeeper('${keeper.keeperID}')">
                                <i class="bi bi-trash"></i>
                            </button>
                        </div>
                    </div>
                `;
                container.appendChild(card);
            });

            resolve();
        } catch (error) {
            console.error("Error al cargar keepers:", error);
            alert("Hubo un problema al cargar los keepers.");
            resolve(); // Resolver para evitar bloqueos aunque haya error
        }
    });
}


function showEditKeeperModal(id, name, phone, specialty) {
    console.log("Editar Keeper ID:", id);

    document.getElementById('editKeeperId').value = id;
    document.getElementById('editKeeperName').value = name;
    document.getElementById('editKeeperPhone').value = phone;
    document.getElementById('editKeeperSpecialty').value = specialty;
    document.getElementById('editKeeperError').classList.add("d-none");

    const modal = new bootstrap.Modal(document.getElementById('editKeeperModal'));
    modal.show();
}

async function updateKeeper() {
    const id = document.getElementById('editKeeperId').value;
    const name = document.getElementById('editKeeperName').value.trim();
    const phone = document.getElementById('editKeeperPhone').value.trim();
    const specialty = document.getElementById('editKeeperSpecialty').value.trim();

    if (!name || !phone || !specialty) {
        document.getElementById('editKeeperError').classList.remove("d-none");
        return;
    }

    const body = {
        nameKeeper: name,
        phone: phone,
        specialty: specialty
    };

    try {
        const response = await fetch(`http://localhost:8080/keeper/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(body)
        });

        if (!response.ok) throw new Error("Error al actualizar el cuidador");

        const modal = bootstrap.Modal.getInstance(document.getElementById('editKeeperModal'));
        modal.hide();

        getKeepers(); // recarga lista
    } catch (err) {
        alert("Error actualizando cuidador");
        console.error(err);
    }
}


function deleteKeeper(id) {
    if (!confirm("¿Estás seguro de que deseas eliminar este cuidador?")) return;

    fetch(`http://localhost:8080/keeper/${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => {
        if (!response.ok) throw new Error("No se pudo eliminar");
        return response.text();
    })
    .then(() => {
        alert("Cuidador eliminado con éxito");
        getKeepers();
    })
    .catch(error => {
        console.error("Error al eliminar cuidador:", error);
        alert("No se pudo eliminar el cuidador.");
    });
}



