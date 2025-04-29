document.addEventListener("DOMContentLoaded", function() {
    getAnimals(); // Llama a la función para listar animales al cargar la página
});

async function getAnimals() {
    try {
        const response = await fetch('http://localhost:8080/animal/'); // Ajusta la URL si es diferente
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        console.log("Datos recibidos del servidor:", data); // Para verificar la respuesta
        displayAnimals(data);
    } catch (error) {
        console.error('Error fetching animals:', error);
        alert('Error al cargar la lista de animales.');
    }
}

function displayAnimals(animals) {
    const container = document.getElementById('animalCardsContainer');
    container.innerHTML = ''; // Limpiar el contenedor antes de agregar los animales

    animals.forEach(animal => {
        // Crear una fila (row) para cada animal
        const row = document.createElement("div");
        row.className = "row align-items-center mb-2";

        // Nombre del animal
        const nameDiv = document.createElement("div");
        nameDiv.className = "col-2";
        nameDiv.textContent = animal.nameAnimal;

        // Fecha de nacimiento
        const birthDiv = document.createElement("div");
        birthDiv.className = "col-2";
        birthDiv.textContent = animal.dateBirth;

        // Foto
        const photoDiv = document.createElement("div");
        photoDiv.className = "col-1 d-flex justify-content-center";
        const img = document.createElement("img");
        img.src = animal.foto;
        img.alt = "Animal Photo";
        img.style.width = "50px";
        img.style.height = "50px";
        img.style.objectFit = "cover";
        img.style.borderRadius = "8px";
        photoDiv.appendChild(img);

        // Especie
        const speciesDiv = document.createElement("div");
        speciesDiv.className = "col-2";
        speciesDiv.textContent = animal.species ? animal.species.nameSpecies : "N/A";

        // Sección
        const sectionDiv = document.createElement("div");
        sectionDiv.className = "col-2";
        sectionDiv.textContent = animal.section ? animal.section.nameSection : "N/A";

        // Estado
        const statusDiv = document.createElement("div");
        statusDiv.className = "col-1";
        statusDiv.textContent = animal.status ? animal.status.nameStatus : "N/A";

        // Botones de acción
        const actionsDiv = document.createElement("div");
        actionsDiv.className = "col-2 d-flex justify-content-center align-items-center gap-2";

        let btnEdit = document.createElement("button");
        btnEdit.className = "btn btn-sm btn-primary";
        btnEdit.innerHTML = `<i class="bi bi-pencil"></i>`;
        btnEdit.addEventListener("click", function () {
            showEditModal(
                animal.animalID,
                animal.nameAnimal,
                animal.dateBirth,
                animal.foto,
                animal.species?.speciesID,
                animal.section?.sectionID,
                animal.status?.statusID
            );
        });

        let btnDelete = document.createElement("button");
        btnDelete.className = "btn btn-sm btn-danger";
        btnDelete.innerHTML = `<i class="bi bi-trash"></i>`;
        btnDelete.addEventListener("click", function () {
            deleteAnimal(animal.animalID);
        });

        actionsDiv.appendChild(btnEdit);
        actionsDiv.appendChild(btnDelete);

        // Agregar todos los divs al row
        row.appendChild(nameDiv);
        row.appendChild(birthDiv);
        row.appendChild(photoDiv);
        row.appendChild(speciesDiv);
        row.appendChild(sectionDiv);
        row.appendChild(statusDiv);
        row.appendChild(actionsDiv);

        // Agregar la fila al contenedor principal
        container.appendChild(row);
    });
}

// ... (tu código existente de getAnimals y displayAnimals) ...

let currentAnimalId = null; // Variable para almacenar el ID del animal que se está editando

function showEditModal(animalID, nameAnimal, dateBirth, foto, speciesID, sectionID, statusID) {
    currentAnimalId = animalID;
    document.getElementById('editAnimalID').value = animalID;
    document.getElementById('editNameAnimal').value = nameAnimal;
    document.getElementById('editDateBirth').value = dateBirth;
    document.getElementById('editFoto').value = foto;

    // Cargar las opciones de especies, secciones y estados en el modal
    loadSpeciesOptionsForEdit(speciesID);
    loadSectionsOptionsForEdit(sectionID);
    loadStatusesOptionsForEdit(statusID);

    editAnimalModal.show();
}

async function loadSpeciesOptionsForEdit(selectedSpeciesID) {
    try {
        const response = await fetch("http://localhost:8080/species/");
        if (!response.ok) {
            throw new Error("No se pudo obtener la lista de especies.");
        }
        const speciesList = await response.json();
        const select = document.getElementById("editSpeciesID");
        select.innerHTML = '<option value="">Select a species</option>';
        speciesList.forEach(species => {
            const option = document.createElement("option");
            option.value = species.speciesID;
            option.textContent = species.nameSpecies;
            if (species.speciesID === selectedSpeciesID) {
                option.selected = true;
            }
            select.appendChild(option);
        });
    } catch (error) {
        console.error("Error al cargar las especies para editar:", error);
        alert("Error al cargar las especies disponibles para editar.");
    }
}

async function loadSectionsOptionsForEdit(selectedSectionID) {
    try {
        const response = await fetch("http://localhost:8080/section/");
        if (!response.ok) {
            throw new Error("No se pudo obtener la lista de secciones.");
        }
        const sectionsList = await response.json();
        const select = document.getElementById("editSectionID");
        select.innerHTML = '<option value="">Select a section</option>';
        sectionsList.forEach(section => {
            const option = document.createElement("option");
            option.value = section.sectionID;
            option.textContent = section.nameSection;
            if (section.sectionID === selectedSectionID) {
                option.selected = true;
            }
            select.appendChild(option);
        });
    } catch (error) {
        console.error("Error al cargar las secciones para editar:", error);
        alert("Error al cargar las secciones disponibles para editar.");
    }
}

async function loadStatusesOptionsForEdit(selectedStatusID) {
    try {
        const response = await fetch("http://localhost:8080/status/");
        if (!response.ok) {
            throw new Error("No se pudo obtener la lista de estados.");
        }
        const statusesList = await response.json();
        const select = document.getElementById("editStatusID");
        select.innerHTML = '<option value="">Select a status</option>';
        statusesList.forEach(status => {
            const option = document.createElement("option");
            option.value = status.statusID;
            option.textContent = status.nameStatus;
            if (status.statusID === selectedStatusID) {
                option.selected = true;
            }
            select.appendChild(option);
        });
    } catch (error) {
        console.error("Error al cargar los estados para editar:", error);
        alert("Error al cargar los estados disponibles para editar.");
    }
}

async function updateAnimal() {
    if (!currentAnimalId) {
        alert("No se ha seleccionado ningún animal para editar.");
        return;
    }

    const updatedAnimalData = {
        animalID: currentAnimalId,
        nameAnimal: document.getElementById('editNameAnimal').value,
        dateBirth: document.getElementById('editDateBirth').value,
        foto: document.getElementById('editFoto').value,
        species: {
            speciesID: parseInt(document.getElementById('editSpeciesID').value)
        },
        section: {
            sectionID: parseInt(document.getElementById('editSectionID').value)
        },
        status: {
            statusID: parseInt(document.getElementById('editStatusID').value)
        }
    };

    try {
        const response = await fetch(`http://localhost:8080/animal/${currentAnimalId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedAnimalData)
        });

        if (response.ok) {
            const result = await response.text();
            console.log('✅ Animal actualizado:', result);
            alert('Animal actualizado correctamente');
            editAnimalModal.hide(); // Ocultar el modal después de la actualización
            getAnimals(); // Recargar la lista de animales para mostrar los cambios
        } else {
            const error = await response.text();
            console.error('❌ Error al actualizar el animal:', response.status, error);
            alert('Error al actualizar el animal');
        }
    } catch (error) {
        console.error('❌ Error en la solicitud de actualización:', error);
        alert('Error de conexión con el servidor al actualizar.');
    }
}

// ... (tu función deleteAnimal) ...
async function deleteAnimal(animalID) {
    if (confirm(`¿Estás seguro de que quieres eliminar el animal con ID: ${animalID}?`)) {
        try {
            const response = await fetch(`http://localhost:8080/animal/${animalID}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                const result = await response.text();
                console.log('✅ Animal eliminado:', result);
                alert('Animal eliminado correctamente');
                getAnimals(); // Recargar la lista de animales para reflejar la eliminación
            } else {
                const error = await response.text();
                console.error('❌ Error al eliminar el animal:', response.status, error);
                alert('Error al eliminar el animal');
            }
        } catch (error) {
            console.error('❌ Error en la solicitud de eliminación:', error);
            alert('Error de conexión con el servidor al eliminar.');
        }
    }
}

