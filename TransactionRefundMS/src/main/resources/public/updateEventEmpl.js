window.onload = function(){

    let parameters = location.search.substring(1).split("?");
    let param = parameters[0].split("=");

    let eventId = param[1];
    console.log(parameters);

    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/readEventById/" + eventId;
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr.responseText);
            let event= JSON.parse(xhr.responseText);
            console.log(event);

            let name=document.getElementById("name");
            let startDate=document.getElementById("startDate");
            let endDate=document.getElementById("endDate");
            let location=document.getElementById("location");
            let eventTypeId=document.getElementById("eventTypeId");
            let description=document.getElementById("description");
            let format=document.getElementById("format");

            name.value=event.name;
            startDate.value=event.startDate;
            endDate.value=event.endDate;
            location.value=event.location;
            eventTypeId.value=event.eventTypeId;
            description.value=event.description;
            format.value=event.amountRequested;

            let form=document.getElementById("updateEvent");
            form.action = "http://localhost:9094/updateEvent/" +  eventId;
            //neeeed tooo implementtttttt the update in JAVA

        }
    }
        xhr.open("GET", url, true);

    xhr.send();
}
    

