let baseUrl = "http://localhost:8081"; //might have to change port

function logout() {
    sessionStorage.clear();
}

async function PopulateBuilds() {

    let foundUser = (sessionStorage.getItem('inUser'));

    if (foundUser == null) {
        console.log("your not logged in!");
        // return;
    }

    else {
        let res = await fetch(`
                ${baseUrl}/users/${JSON.parse(foundUser).id}/builds`,
            {
                method: 'GET',
                header: { 'Content-Type': 'application/json' }
            });

        let resJson = await res.json()
            .then((resp) => {
                console.log(resp);

                let table = document.getElementById("buildTableBody");

                for (let entry of resp) {

                    var row = table.insertRow(-1);

                    var cell0 = row.insertCell(0);

                    var cell1 = row.insertCell(1);

                    var cell2 = row.insertCell(2);

                    var cell3 = row.insertCell(3);

                    var cell4 = row.insertCell(4);

                    var cell5 = row.insertCell(5);

                    var cell6 = row.insertCell(6);

                    var cell7 = row.insertCell(7);

                    var cell8 = row.insertCell(8);

                    var cell9 = row.insertCell(9);

                    var cell10 = row.insertCell(10);


                    cell0.innerText = entry.buildId;
                    cell1.innerText = entry.buildName;
                    cell2.innerText = entry.moboName;
                    cell3.innerText = entry.cpuName;

                    let ramy = entry.ramName;
                    if (!entry.hasFourRAM) {
                        ramy += " x2"
                    }
                    else {
                        ramy += " x4"
                    }
                    cell4.innerText = ramy;


                    cell5.innerText = entry.storageName;
                    cell6.innerText = entry.psuName;
                    cell7.innerText = entry.caseName;
                    cell8.innerText = `$${entry.totalCost.toFixed(2)}`;
                    cell9.innerHTML = `<button type='button' class='btn btn-primary' onclick='update(this)'>Edit</button>`;
                    cell10.innerHTML = `<button type='button' class='btn btn-primary' onclick='deleteRow(this)'>Delete</button>`;

                }
            })

            .catch((error) => {
                console.log(error);
            });

    }
}



function update(cell) {
    let rowNum = cell.closest("tr").rowIndex;
    let getId = document.getElementById("buildTable").rows[rowNum].cells[0].innerHTML;

    sessionStorage.setItem("fetchThis", JSON.stringify(getId));
    // console.log(getId);
    //  console.log(JSON.parse(sessionStorage.getItem('fetchThis')));
    window.location.assign("editBuildPage.html");

}

async function deleteRow(cell) {
    rowNum = cell.closest("tr").rowIndex;
    let id = document.getElementById("buildTable").rows[rowNum].cells[0].innerHTML;

    let user = JSON.parse(sessionStorage.getItem("inUser"));

    let res = await fetch(
        `${baseUrl}/users/${user.id}/builds/${id}`,
        {
            method: 'DELETE',
            header: { 'Content-Type': 'application/json' }
        }
    );
    let resJson = await res.json()
        .then((resp) => {
            if (res.status === 404) {
                alert(resp.message);
            } else {
                document.getElementById("buildTable").deleteRow(rowNum);
            }
        })
        .catch((error) => {
            console.log(error);
            alert('Failed to delete build');
        });
}

async function showOtherBuilds() {
    let newTable = document.createElement('table');
    let holderDiv = document.getElementById("holder");
    
    newTable.innerHTML = `<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Motherboard</th>
    <th>CPU</th>
    <th>RAM</th>
    <th>Storage</th>
    <th>PSU</th>
    <th>Case</th>
    <th>Total Cost</th>
    </tr>`


    let foundUser = (sessionStorage.getItem('inUser'));

    if (foundUser == null) {
        console.log("your not logged in!");
        // return;
    }

    else {
        let res = await fetch(`
                    ${baseUrl}/users/${JSON.parse(foundUser).id}/otherBuilds`,
            {
                method: 'GET',
                header: { 'Content-Type': 'application/json' },
            });

        let resJson = await res.json()

            .then((resp) => {
                console.log(resp);
                holderDiv.innerHTML = "";

                // let table = document.getElementById("buildTableBody");

                for (let entry of resp) {

                    var row = newTable.insertRow(-1);

                    var cell0 = row.insertCell(0);

                    var cell1 = row.insertCell(1);

                    var cell2 = row.insertCell(2);

                    var cell3 = row.insertCell(3);

                    var cell4 = row.insertCell(4);

                    var cell5 = row.insertCell(5);

                    var cell6 = row.insertCell(6);

                    var cell7 = row.insertCell(7);

                    var cell8 = row.insertCell(8);

                    cell0.innerText = entry.buildId;
                    cell1.innerText = entry.buildName;
                    cell2.innerText = entry.moboName;
                    cell3.innerText = entry.cpuName;

                    let ramy = entry.ramName;
                    if (!entry.hasFourRAM) {
                        ramy += " x2"
                    }
                    else {
                        ramy += " x4"
                    }
                    cell4.innerText = ramy;

                    cell5.innerText = entry.storageName;
                    cell6.innerText = entry.psuName;
                    cell7.innerText = entry.caseName;
                    cell8.innerText = `$${entry.totalCost.toFixed(2)}`;
                }
            })

            .catch((error) => {
                console.log(error);
            });

    }

    holderDiv.appendChild(newTable);
} 