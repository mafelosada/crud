document.addEventListener("DOMContentLoaded", function() {
    // Cargar las opciones de especies
    async function loadSpeciesOptions() {
        try {
            const response = await fetch("http://localhost:8080/species/", {
                method: "GET",
                headers: {
                    "Accept": "*/*",
                    "Content-Type": "application/json"
                }
            });

            if (!response.ok) {
                throw new Error("No se pudo obtener la lista de especies.");
            }

            const speciesList = await response.json();
            const select = document.getElementById("speciesID");
            select.innerHTML = '<option value="">Select a species</option>';

            speciesList.forEach(species => {
                const option = document.createElement("option");
                option.value = species.speciesID;
                option.textContent = species.nameSpecies;
                select.appendChild(option);
            });

        } catch (error) {
            console.error("Error al cargar las especies:", error);
            alert("Error al cargar las especies disponibles.");
        }
    }

    // Cargar las opciones de secciones
    async function loadSectionsOptions() {
        try {
            const response = await fetch("http://localhost:8080/section/", {
                method: "GET",
                headers: {
                    "Accept": "*/*",
                    "Content-Type": "application/json"
                }
            });

            if (!response.ok) {
                throw new Error("No se pudo obtener la lista de secciones.");
            }

            const sectionsList = await response.json();
            const select = document.getElementById("sectionID");
            select.innerHTML = '<option value="">Select a section</option>';

            sectionsList.forEach(section => {
                const option = document.createElement("option");
                option.value = section.sectionID;
                option.textContent = section.nameSection;
                select.appendChild(option);
            });

        } catch (error) {
            console.error("Error al cargar las secciones:", error);
            alert("Error al cargar las secciones disponibles.");
        }
    }

    // Cargar las opciones de estado
    async function loadStatusesOptions() {
        try {
            const response = await fetch("http://localhost:8080/status/", {
                method: "GET",
                headers: {
                    "Accept": "*/*",
                    "Content-Type": "application/json"
                }
            });

            if (!response.ok) {
                throw new Error("No se pudo obtener la lista de estados.");
            }

            const statusesList = await response.json();
            const select = document.getElementById("statusID");
            select.innerHTML = '<option value="">Select a status</option>';

            statusesList.forEach(status => {
                const option = document.createElement("option");
                option.value = status.statusID;
                option.textContent = status.nameStatus;
                select.appendChild(option);
            });

        } catch (error) {
            console.error("Error al cargar los estados:", error);
            alert("Error al cargar los estados disponibles.");
        }
    }

    // Registrar un animal
    async function registerAnimal(event) {
        event.preventDefault(); // Evita el envío tradicional del formulario

        // Validación extra: comprobar que todas las opciones han sido seleccionadas
        const nameAnimal = document.getElementById('nameAnimal').value;
        const dateBirth = document.getElementById('dateBirth').value;
        const foto = document.getElementById('foto').value;
        const speciesID = document.getElementById('speciesID').value;
        const sectionID = document.getElementById('sectionID').value;
        const statusID = document.getElementById('statusID').value;

        if (!nameAnimal || !dateBirth || !foto || !speciesID || !sectionID || !statusID) {
            alert("Please fill in all fields.");
            return;
        }

        // Crear objeto animal
        const animalData = {
            nameAnimal: nameAnimal,
            dateBirth: dateBirth,
            foto: foto,
            species: {
                speciesID: parseInt(speciesID)
            },
            section: {
                sectionID: parseInt(sectionID)
            },
            status: {
                statusID: parseInt(statusID)
            }
        };

        try {
            const response = await fetch('http://localhost:8080/animal/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(animalData)
            });

            if (response.ok) {
                const result = await response.text();
                console.log('✅ Animal registrado:', result);
                alert('Animal registrado correctamente');
            } else {
                const error = await response.text();
                console.error('❌ Error al registrar el animal:', response.status, error);
                alert('Error al registrar el animal');
            }
        } catch (error) {
            console.error('❌ Error en la solicitud:', error);
            alert('Error de conexión con el servidor');
        }
    }

    async function registerAnimal(event) {
        event.preventDefault(); // Evita el envío tradicional del formulario
    
        // Validación extra: comprobar que todas las opciones han sido seleccionadas
        const nameAnimal = document.getElementById('nameAnimal').value;
        const dateBirth = document.getElementById('dateBirth').value;
        const foto = document.getElementById('foto').value;
        const speciesID = document.getElementById('speciesID').value;
        const sectionID = document.getElementById('sectionID').value;
        const statusID = document.getElementById('statusID').value;
    
        if (!nameAnimal || !dateBirth || !foto || !speciesID || !sectionID || !statusID) {
            alert("Please fill in all fields.");
            return;
        }
    
        // Crear objeto animal
        const animalData = {
            nameAnimal: nameAnimal,
            dateBirth: dateBirth,
            foto: foto,
            species: {
                speciesID: parseInt(speciesID)
            },
            section: {
                sectionID: parseInt(sectionID)
            },
            status: {
                statusID: parseInt(statusID)
            }
        };
    
        try {
            // Aquí está la solicitud POST configurada correctamente
            const response = await fetch('http://localhost:8080/animal/', {
                method: 'POST', // Asegúrate de que sea un POST
                headers: {
                    'Content-Type': 'application/json' // El tipo de contenido debe ser JSON
                },
                body: JSON.stringify(animalData) // Envía los datos correctamente formateados como JSON
            });
    
            // Verifica si la respuesta fue exitosa
            if (response.ok) {
                const result = await response.text(); // O espera un JSON si el servidor responde con JSON
                console.log('✅ Animal registrado:', result);
                alert('Animal registrado correctamente');
            } else {
                const error = await response.text();
                console.error('❌ Error al registrar el animal:', response.status, error);
                alert('Error al registrar el animal');
            }
        } catch (error) {
            console.error('❌ Error en la solicitud:', error);
            alert('Error de conexión con el servidor');
        }
    }

    document.getElementById('animalForm').addEventListener('submit', registerAnimal);

        // Cargar todas las opciones y animales al cargar la página
        loadSpeciesOptions();
        loadSectionsOptions();
        loadStatusesOptions();
    
});
