
var request = null;
var rooturl = "http://localhost:8080/PainDiary/webresources/restclient.doctor";
function createRequest() {
    try {
        request = new XMLHttpRequest();
    } catch (trymicrosoft) {
        try {
            request = new ActiveXObject("MsXML2.XMLHTTP");
        } catch (othermicrosoft) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = null;
            }
        }
    }
    if (request == null)
        alert("Error creating request object!");
}

function getAllDoctor()
{
    document.getElementById('docId').value = "";
    document.getElementById('docFname').value = "";
    document.getElementById('docLname').value = "";
    document.getElementById('docPhone').value = "";
    document.getElementById('clinicAddress').value = "";
    document.getElementById('clinicPhone').value = "";
    createRequest();
    request.onreadystatechange = handleListJSONResponse;
    request.open("GET", rooturl, true);
    request.send(null);
}


function getDoctor()
{
    document.getElementById("output").innerHTML = "";
    document.getElementById('docFname').value = "";
    document.getElementById('docLname').value = "";
    document.getElementById('docPhone').value = "";
    document.getElementById('clinicAddress').value = "";
    document.getElementById('clinicPhone').value = "";
    createRequest();
    var id = document.getElementById("docId").value;
    var url = rooturl + "/" + id;
    request.onreadystatechange = handleJSONResponse;
    request.open("GET", url, true);
    request.send(null);
}
function addDoctor()
{
    document.getElementById("output").innerHTML = "";
    var docId = document.getElementById('docId').value;
    var regId = document.getElementById('regId').value;
    var docFname = document.getElementById('docFname').value;
    var docLname = document.getElementById('docLname').value;
    var docPhone = document.getElementById('docPhone').value;
    var clinicAddress = document.getElementById('clinicAddress').value;
    var clinicPhone = document.getElementById('clinicPhone').value;
    createRequest();
    var data = JSON.stringify({"clinicAddress": clinicAddress.toString(),
        "clinicPhone": clinicPhone.toString(),
        "docFname": docFname.toString(),
        "docId": docId.toString(),
        "docLname": docLname.toString(),
        "docPhone": docPhone.toString(),
        "regId": regId.toString(),
        
        });
    request.open("POST", rooturl);
    request.setRequestHeader('Content-type', 'application/json');
    request.setRequestHeader("Content-Length", data.length);
    request.setRequestHeader('Accept', 'application/json');
    request.send(data);
    document.getElementById('docId').value = "";
    document.getElementById('regId').value = "";
    document.getElementById('docFname').value = "";
    document.getElementById('docLname').value = "";
    document.getElementById('docPhone').value = "";
    document.getElementById('clinicAddress').value = "";
    document.getElementById('clinicPhone').value = "";
}

function deleteDoctor()
{
    document.getElementById("output").innerHTML = "";
    createRequest();
    var id = document.getElementById("docId").value;
    var url = rooturl + "/" + id;
    request.open("DELETE", url, true);
    request.send(null);
    document.getElementById('docId').value = "";
    document.getElementById('regId').value = "";
    document.getElementById('docFname').value = "";
    document.getElementById('docLname').value = "";
    document.getElementById('docPhone').value = "";
    document.getElementById('clinicAddress').value = "";
    document.getElementById('clinicPhone').value = "";
}

function updateDoctor()
{
    document.getElementById("output").innerHTML = "";
    var docId = document.getElementById('docId').value;
    var regId = document.getElementById('regId').value;
    var docFname = document.getElementById('docFname').value;
    var docLname = document.getElementById('docLname').value;
    var docPhone = document.getElementById('docPhone').value;
    var clinicAddress = document.getElementById('clinicAddress').value;
    var clinicPhone = document.getElementById('clinicPhone').value;
    createRequest();
    var data = JSON.stringify({"docId": docId.toString(),
        "regId": regId.toString(),
        "docFname": docFname.toString(),
        "docLname": docLname.toString(),
        "docPhone": docPhone.toString(),
        "clinicAddress": clinicAddress.toString(),
    "clinicPhone": clinicPhone.toString()});
    var url = rooturl + "/" + docId;
    request.open("PUT", url);
    request.setRequestHeader('Content-type', 'application/json');
    request.setRequestHeader("Content-Length", data.length);
    request.setRequestHeader('Accept', 'application/json');
    request.send(data);
    document.getElementById('docId').value = "";
    document.getElementById('regId').value = "";
    document.getElementById('docFname').value = "";
    document.getElementById('docLname').value = "";
    document.getElementById('docPhone').value = "";
    document.getElementById('clinicAddress').value = "";
    document.getElementById('clinicPhone').value = "";
}




function handleJSONResponse() {
    if (request.readyState == 4 && request.status == 200)
    {
        var det = JSON.parse(request.responseText);
        document.getElementById('regId').value = det.regId;
        document.getElementById('docFname').value = det.docFname;
        document.getElementById('docLname').value = det.docLname;
        document.getElementById('docPhone').value = det.docPhone;
        document.getElementById('clinicAddress').value = det.clinicAddress;
        document.getElementById('clinicPhone').value = det.clinicPhone;
        
    }
}

function handleListJSONResponse() {
    if (request.readyState == 4 && request.status == 200)
    {
        var det = JSON.parse(request.responseText);
        var output = "<table border = '1'>";
        output += "<tr>" + "<th>ID</th>" + "<th>FirstName</th>" + "<th>LastName</th>"
                + "<th>Phone</th>" + "<th>ClinicAddress</th>" + "<th>ClinicPhone</th>"       
                + "</tr>";
        for (var i = 0; i < det.length; i++) {
            output += "<tr>";
            output += "<td>" + det[i].docId + "</td>";
           // output += "<td>" + det[i].regId + "</td>";
            output += "<td>" + det[i].docFname + "</td>";
            output += "<td>" + det[i].docLname + "</td>";
            output += "<td>" + det[i].docPhone + "</td>";
            output += "<td>" + det[i].clinicAddress + "</td>";
            output += "<td>" + det[i].clinicPhone + "</td>";
            output += "</tr>";
        }
        output += "</table>";
        document.getElementById("output").innerHTML = output;
    }
}

