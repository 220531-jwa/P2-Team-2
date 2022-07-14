let baseUrl = "http://localhost:8081";

window.onload = function () {
    console.log("here");
    getParts();
}

async function getParts() {
    let res = await fetch(
        `${baseUrl}/search`,
        {
            method: 'GET',
            header: { 'Content-Type': 'application/json' }
        }
    );
    let resJson = await res.json()
        .then((resp) => {
            populateDropdowns(resp);
        })
        .catch((error) => {
            console.log(error);
            alert("Failed to get parts");
        });
}

function populateDropdowns(partsList) {
    let moboSelector = document.getElementById('motherboardSelector');
    let cpuSelector = document.getElementById('cpuSelector');
    let ramSelector = document.getElementById('ramSelector');
    let storageSelector = document.getElementById('storageSelector');
    let psuSelector = document.getElementById('psuSelector');
    let caseSelector = document.getElementById('caseSelector');

    for(const part in partsList) {
        let newOption = document.createElement('option');
        let partName = part.part_name;
        newOption.setAttribute("value", part.part_id);
        newOption.innerText = entry.part_name;

        switch(partName) {
            case("mobo"):
                newOption.innerText += " - " + entry.manufacturer + " - " + entry.ram_slots + " RAM Slots";
                moboSelector.appendChild(newOption);
                break;
            case("cpu"):
                newOption.innerText += " - " + entry.manufacturer;
                cpuSelector.appendChild(newOption);
                break;
            case("ram"):
                ramSelector.appendChild(newOption);
                break;
            case("storage"):
                newOption.innerText += " - " + entry.manufacturer;
                storageSelector.appendChild(newOption);
                break;
            case("psu"):
                newOption.innerText += " - " + entry.part_wattage;
                psuSelector.appendChild(newOption);
                break;
            case("case"):
                caseSelector.appendChild(newOption);
                break;
        }
    }
}

async function submitBuild() {
    let submitBtn = document.getElementById('submitBuildBtn');
    // Get selector values
    moboValue = document.getElementById("motherboardSelector").value;
    cpuValue = document.getElementById("cpuSelector").value;
    ramValue = document.getElementById("ramSelector").value;
    storageValue = document.getElementById("storageSelector").value;
    psuValue = document.getElementById("psuSelector").value;
    caseValue = document.getElementById("caseSelector").value;


    // Make sure they have a value
    // Send request
    // Redirect to user home page if successful
    // Display alert if error occurs
}