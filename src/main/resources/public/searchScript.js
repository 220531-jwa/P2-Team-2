// let baseUrl = "http://localhost:8081";
async function searchForParts() {

    let min = document.getElementById("priceFloorInput").value;
    if (min.length === 0) {
        min = 0;
    }

    let max = document.getElementById("priceCeilingInput").value;
    if (max.length === 0 || max == 0) {
        max = 99999999.99;
    }

    console.log(`min: ${min}`);
    console.log(`max: ${max}`);

    if ((max - min) < 0) {
        alert("invalid range!");
        return;
    }

    // let typeSelector = document.getElementById("partTypeSelector");
    // let type;

    // if (typeSelector.options[typeSelector.selectedIndex].value == 'ALL'){
    //     // console.log('nice');

    // }
    // console.log(typeSelector.options[typeSelector.selectedIndex].value);

    let res = await fetch(
        `${baseUrl}/search?priceFloor=${min}&priceCeiling=${max}`,
        // `${baseUrl}/search`,

        {
            method: 'GET',
            header: { 'Content-Type': 'application/json' }


        });
    let resJson = await res.json()
        .then((resp) => {
            if (res.status === 404) {
                alert(resp.message);
            }
            console.log(resp);

            let table = document.getElementById("body");
            table.innerHTML = "";

            for (const entry of resp) {
                var row = table.insertRow(-1);

                var cell0 = row.insertCell(0);
                var cell1 = row.insertCell(1);
                var cell2 = row.insertCell(2);
                var cell3 = row.insertCell(3);
                var cell4 = row.insertCell(4);
                var cell5 = row.insertCell(5);

                cell0.innerText = entry.partName;
                cell1.innerText = entry.partId;
                cell2.innerText = entry.partPrice;
                cell3.innerText = entry.partWattage;
                cell4.innerText = entry.manufacturer;
                cell5.innerText = entry.ramSlots;

            }
        })

        .catch((error) => {
            console.log(error);
            console.log(error);
        });
}
function guestLogin() {

    let foundUser = (sessionStorage.getItem('inUser'));
    console.log(foundUser);
    if (foundUser === null) {
        var homeLink = document.getElementById("home");
        var logLink = document.getElementById("logout");

        homeLink.setAttribute("href", "javascript: void(0)");
        homeLink.classList.add("disabled");

        logLink.innerText = "Go Login!";
    }
}