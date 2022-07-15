let baseUrl = "http://localhost:8081"; //might have to change port

function logout(){
    sessionStorage.clear();
}

async function PopulateBuilds(){

    let foundUser = (sessionStorage.getItem('inUser'));

    if (foundUser == null){
        console.log("your not logged in!");
        // return;
    }

    else{
        let res = await fetch(`
                ${baseUrl}/users/${JSON.parse(foundUser).id}/builds`, //endpoint?
                {
                    method: 'GET',
                    header: {'Content-Type': 'application/json'},
                    
                    
                });

        let resJson = await res.json()

        .then((resp) =>{
            console.log(resp);

            let table = document.getElementById("buildTableBody");
            let rowcounter = 1;
            let datacounter = 1;

             for (let entry of resp){

             var row = table.insertRow(-1);
             row.id = ("build" + rowcounter);   

             var cell0 = row.insertCell(0);
             cell0.id='Build ID';
             var cell1 = row.insertCell(1);
             cell1.id='Build Name';
             var cell2 = row.insertCell(2);
             cell2.id='Motherboard';
             var cell3 = row.insertCell(3);
             cell3.id='CPU';
             var cell4 = row.insertCell(4);
             cell4.id='RAM';
             var cell5 = row.insertCell(5);
             cell5.id='Storage';
             var cell6 = row.insertCell(6);
             cell6.id='PSU';
             var cell7 = row.insertCell(7);
             cell7.id='Case';
             var cell8 = row.insertCell(8);
             cell8.id='Total Cost';
             var cell9 = row.insertCell(9);
             cell9.id='Edit Build';

             rowcounter++;
             
            cell0.innerText = entry.buildId;
            cell1.innerText = entry.buildName;
            cell2.innerText = entry.moboName;
            cell3.innerText = entry.cpuName;

            let ramy = entry.ramName;
            if (!entry.hasFourRAM)
                {ramy +=" x2"
            }
            else{
                ramy +=" x4"
            }
            cell4.innerText = ramy;
            
            
            cell5.innerText = entry.storageName;
            cell6.innerText = entry.psuName;
            cell7.innerText = entry.caseName;
            cell8.innerText = `$${entry.totalCost}`;
            cell9.innerHTML = `<button type='button' class='btn btn-primary' onclick='update(this)'>Edit</button>`;

             }  
        })

        .catch((error)=>{console.log(error);
            console.log(error);
            });
                
    }
}



function update(cell) {
    let rowNum = cell.closest("tr").rowIndex;

    let buildEdit = {
        buildId: document.getElementById(""),
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
    
}

// function test(){
//     let input = document.getElementById("testIn").value;
//     // sessionStorage.removeItem('fetchThis');
//     sessionStorage.setItem('fetchThis',input);
//     window.location.assign("editBuildPage.html");
// }

