let baseUrl = "http://localhost:8081";

window.onload = function () {
    console.log("here");
    // Call populate dropdowns once complete
    // populateDropdowns();
}

async function populateDropdowns() {
    let res = await fetch(
        `${baseUrl}/parts`,
        {
            method: 'GET',
            header: { 'Content-Type': 'application/json' }
        }
    );
    let resJson = await res.json()
        .then((resp) => {
            fillTable(resp);
        })
        .catch((error) => {
            console.log(error);
            alert("Failed to get parts");
        });
}

async function submitBuild(){
    //TODO
}