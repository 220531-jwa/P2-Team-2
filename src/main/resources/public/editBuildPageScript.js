window.onload = function () {
    // console.log(JSON.parse(sessionStorage.getItem('fetchThis')));
    getParts();
}

async function editBuild() {
    // let submitBtn = document.getElementById('submitEditBuild');

    buildIdValue = document.getElementById('buildIdInput').value; // If I can't get ID from session
    nameValue = document.getElementById('nameInput').value;
    moboValue = document.getElementById('motherboardSelector').value;
    cpuValue = document.getElementById('cpuSelector').value;
    ramValue = document.getElementById('ramSelector').value;
    hasFourRamValue = document.getElementById('hasFourRAMCheckbox').checked;
    storageValue = document.getElementById('storageSelector').value;
    psuValue = document.getElementById('psuSelector').value;
    caseValue = document.getElementById('caseSelector').value;

    nameValue = nameValue.trim();

    if (buildIdValue === 'none') {
        alert('Select a Build');
        return;
    } else if (nameValue === 'none') {
        alert('Name the Build');
        return;
    } else
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

    let buildEdit = {
        buildId: buildIdValue,
        buildName: nameValue,
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

    console.log(buildEdit);

    let rJson = JSON.stringify(buildEdit);

    let res = await fetch(
        `${baseUrl}/users/${user.id}/builds/${buildIdValue}`,
        {
            method: 'PUT',
            header: { 'Content-Type': 'application/json' },
            body: rJson
        }
    );
    let resJson = await res.json()
        .then((resp) => {
            if (res.status === 400) {
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