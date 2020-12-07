function getReimbReportsTo(){
    //create table in DIV
    let div=document.getElementById("reimbursement-table");
    let table= document.createElement("table");
    table.className="table";
    table.id="reimbursement-table";
    let trow1=document.createElement("th"); //employee id
    let trow2=document.createElement("th"); // sumbit date
    let trow3=document.createElement("th"); // amount requested
    let trow4=document.createElement("th"); // notes
    let trow5=document.createElement("th"); //event_id
    let trow6=document.createElement("th"); //employeeCancel
    let trow7=document.createElement("th"); //file
    div.appendChild(table);
    trow1.innerHTML="Employee ID"
    trow2.innerHTML="Submit Date";
    trow3.innerHTML="Amount requested";
    trow4.innerHTML="Notes";
    trow5.innerHTML="Event_id";
    trow6.innerHTML="Employee Cancelled?";
    trow7.innerHTML="File Uploads";

    table.appendChild (trow1);
    table.appendChild (trow2);
    table.appendChild (trow3);
    table.appendChild (trow4);
    table.appendChild (trow5);
    

    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/reimbursementsReportsTo";
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200){
            console.log(xhr.responseText);
            let reimbursementList = JSON.parse(xhr.responseText);
            
            reimbursementList.forEach(element => {
                let tableRow = document.createElement("tr");

                let employee_id = document.createElement("td");
                let submit_date = document.createElement("td");
                let amount_requested = document.createElement("td");
                let notes = document.createElement("td");
                let event_id= document.createElement("td");
                let cancel= document.createElement("td");
                let file= document.createElement("td");

                employee_id.innerHTML= element.employeeId;
                submit_date.innerHTML = element.dateSubmition;
                //approval date
                amount_requested.innerHTML ="$ "+ element.amountRequested;
                notes.innerHTML = element.notes; // input box, edit button 
                event_id.innerHTML = element.eventId;
                cancel.innerHTML= element.employeeCancelation;
                file.

                tableRow.appendChild(employee_id);
                tableRow.appendChild(submit_date);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(notes);
                tableRow.appendChild(event_id);
                table.appendChild(tableRow);
           });
        }
    }
    xhr.open("GET", url, true);
    xhr.send();
}
function redirect_form(){
    window.location.replace("http://localhost:9094/newRequest");
}