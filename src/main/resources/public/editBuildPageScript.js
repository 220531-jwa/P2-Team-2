//test

function changeColor(selected){
    // console.log(selected.value.classList.contains("default"));
    // if (selected.option.classList.contains("default")){
    //     console.log("BRO");
    // }

    

}

//end test



window.onload = async function () {
    let user = JSON.parse(sessionStorage.getItem("inUser"));
    let getIt =JSON.parse(sessionStorage.getItem('fetchThis'))
    // console.log(getIt);
     await getParts();
    
     let res = await fetch(`
     ${baseUrl}/users/${user.id}/builds/${getIt}`,
     {
         method: 'GET',
         header: {'Content-Type': 'application/json'},
         
         
     });

     let resJson = await res.json()
     .then((resp) =>{

        //test

       


        // document.getElementById("nameInput").value = resp.buildName;
        // var moboSel = document.getElementById("motherboardSelector");
        // for (let i = 0; i < moboSel.length; i++){
        //     // console.log(moboSel.options[i].innerText);
        //     if (moboSel.options[i].innerText ===resp.moboName){
        //         moboSel.options[i].selected = true;
        //         moboSel.options[i].classList.add("default");
                
        //     }
        // }

        //end test
        // console.log(resp);
        
        // let table = document.getElementById("buildTableBody");
        
        //  var row = table.insertRow(-1);
      

        //  var cell0 = row.insertCell(0);
        //  cell0.id='Build ID';
        //  var cell1 = row.insertCell(1);
        //  cell1.id='Build Name';
        //  var cell2 = row.insertCell(2);
        //  cell2.id='Motherboard';
        //  var cell3 = row.insertCell(3);
        //  cell3.id='CPU';
        //  var cell4 = row.insertCell(4);
        //  cell4.id='RAM';
        //  var cell5 = row.insertCell(5);
        //  cell5.id='Storage';
        //  var cell6 = row.insertCell(6);
        //  cell6.id='PSU';
        //  var cell7 = row.insertCell(7);
        //  cell7.id='Case';
        //  var cell8 = row.insertCell(8);
        //  cell8.id='Total Cost';
        
         
        // cell0.innerText = resp.buildId;
        // cell1.innerText = resp.buildName;
      
        
        // cell2.innerText = resp.moboName;
        // cell3.innerText = resp.cpuName;

        // let ramy = resp.ramName;
        // if (!resp.hasFourRAM)
        //     {ramy +=" x2"
        // }
        // else{
        //     ramy +=" x4"
        // }
        // cell4.innerText = ramy;
        
        
        // cell5.innerText = resp.storageName;
        // cell6.innerText = resp.psuName;
        // cell7.innerText = resp.caseName;
        // cell8.innerText = `$${resp.totalCost}`;
         document.getElementById("nameInput").value = resp.buildName;
        colorize(document.getElementById("motherboardSelector"),resp.moboName);
        colorize(document.getElementById("cpuSelector"),resp.cpuName);
        colorize(document.getElementById("ramSelector"),resp.ramName);
        colorize(document.getElementById("storageSelector"),resp.storageName);
        colorize(document.getElementById("psuSelector"),resp.psuName);
        colorize(document.getElementById("caseSelector"),resp.caseName);
        if (resp.hasFourRAM){
            document.getElementById("hasFourRAMCheckbox").checked = true;
        }

        function colorize(thisSel, thisData){
            console.log(`thisSel:${thisSel}`);
            console.log(`thisData:${thisData}`);
            for (let i = 0; i < thisSel.length; i++){
                // console.log(moboSel.options[i].innerText);
                console.log(thisSel.innerText);
                // if (thisSel.options[i].innerText ===thisData)
                if (thisSel.options[i].innerText.includes(thisData)){
                    thisSel.options[i].selected = true;
                    thisSel.options[i].classList.add("default");
                    
                }
        }
        }
    })

    .catch((error)=>{console.log(error);
        console.log(error);
        });
            


}


async function editBuild() {
    // buildIdValue = document.getElementById('buildIdInput').value; // If I can't get ID from session

    nameValue = document.getElementById('nameInput').value;
    moboValue = document.getElementById('motherboardSelector').value;
    cpuValue = document.getElementById('cpuSelector').value;
    ramValue = document.getElementById('ramSelector').value;
    hasFourRamValue = document.getElementById('hasFourRAMCheckbox').checked;
    storageValue = document.getElementById('storageSelector').value;
    psuValue = document.getElementById('psuSelector').value;
    caseValue = document.getElementById('caseSelector').value;

    nameValue = nameValue.trim();
    let getIt =JSON.parse(sessionStorage.getItem('fetchThis'))
    if (getIt === 'none') {
        alert('Select a Build');
        return;
    } 
    else if (nameValue === 'none') {
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
        buildId: getIt,
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
        `${baseUrl}/users/${user.id}/builds/${getIt}`,
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