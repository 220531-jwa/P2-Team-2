let baseUrl = 'http://localhost:8081';

window.onload = function () {
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
            if (res.status ===404){
                alert(resp.message);
            } else {
                populateDropdowns(resp);
            }
        })
        .catch((error) => {
            console.log(error);
            alert('Failed to get parts');
        });
}

function populateDropdowns(partsList) {
    let moboSelector = document.getElementById('motherboardSelector');
    let cpuSelector = document.getElementById('cpuSelector');
    let ramSelector = document.getElementById('ramSelector');
    let storageSelector = document.getElementById('storageSelector');
    let psuSelector = document.getElementById('psuSelector');
    let caseSelector = document.getElementById('caseSelector');
    
    for(const part of partsList) {
        let partType = part.partType;
        let newOption = document.createElement('option');
        newOption.setAttribute('value', part.partId);
        newOption.innerText = part.partName;

        switch(partType) {
            case('MOBO'):
                newOption.innerText += ' - ' + part.manufacturer + ' - ' + part.ramSlots + ' RAM Slots';
                moboSelector.appendChild(newOption);
                break;
            case('CPU'):
                newOption.innerText += ' - ' + part.manufacturer;
                cpuSelector.appendChild(newOption);
                break;
            case('RAM'):
                ramSelector.appendChild(newOption);
                break;
            case('STORAGE'):
                storageSelector.appendChild(newOption);
                break;
            case('PSU'):
                newOption.innerText += ' - ' + part.partWattage + 'W';
                psuSelector.appendChild(newOption);
                break;
            case('CASE'):
                caseSelector.appendChild(newOption);
                break;
        }
    }
}

async function submitEditBuild() {
    let submitEditBtn = document.getElementById('submitEditBuildBtn');
    
    nameValue = document.getElementById('nameInput').value;
    moboValue = document.getElementById('motherboardSelector').value;
    cpuValue = document.getElementById('cpuSelector').value;
    ramValue = document.getElementById('ramSelector').value;
    hasFourRamValue = document.getElementById('hasFourRAMCheckbox').checked;
    storageValue = document.getElementById('storageSelector').value;
    psuValue = document.getElementById('psuSelector').value;
    caseValue = document.getElementById('caseSelector').value;

    nameValue = nameValue.trim();

    // Check if fields are filled
    if (moboValue === 'none') {
        alert('Select a Motherboard');
        return;
    } else if (cpuValue === 'none') {
        alert('Select a CPU');
        return;
    } else if (ramValue === 'none') {
        alert('Select RAM');
        return;
    } else if (storageValue === 'none') {
        alert('Select Storage');
        return;
    } else if (psuValue === 'none') {
        alert('Select a PSU');
        return;
    } else if (caseValue === 'none') {
        alert('Select a Case');
        return;
    } else if (nameValue === '') {
        alert('You need a name for a build');
        return;
    }

    let user = JSON.parse(sessionStorage.getItem("inUser"));

    let build = {
        userId: user.userId,
        buildName: nameValue,
        moboId: moboValue,
        cpuId: cpuValue,
        ramId: ramValue,
        storageId: storageValue,
        psuId: psuValue,
        caseId: caseValue,
        hasFourRAM: hasFourRamValue
    };
    
    let rJson = JSON.stringify(build);

    let res = await fetch(
        `${baseUrl}/users/${user.id}/builds`,
        {
            method: 'POST',
            header: { 'Content-Type': 'application/json' },
            body: rJson
        }
    );
    let resJson = await res.json()
        .then((resp) => {
            if (res.status === 400){
                alert(resp.message);
            } else {
                window.location.assign("home.html");
            }
        })
        .catch((error) => {
            console.log(error);
            alert('Failed to create build');
        });
}