// Appel au webscript dir (backend)
var user = args.user;
var nodejsServerUrl = "http://localhost:7000/";
if(user != ""){
    nodejsServerUrl = nodejsServerUrl + "?user=" + user;
}
var connector = remote.connect("http");
var data = connector.get(nodejsServerUrl);

// create json object from data
var results;
if(data != ""){
    results = eval('(' + data + ')');
    if(results.message == undefined){
        results = '{"message" : "Error while parsing the JSON server response !", "userName" : "Not specified"}';
    }	
} else {
  results = '{"message" : "No response received from server !", "userName" : "Not specified"}';
}

// store tasks on model object for use in rendering template
model.message = results.message;
model.userName = results.userName;

