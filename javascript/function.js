function greet(name = "Rohit Kumar"){ //default parameter
      console.log(name);
}
greet();// default parameter as not any  argument passed here


// Callback function: A callback function is a function that is passed to another function

function show(name){
    console.log(`Hello ${name}!, Welcome to our world`);
    
}
function getCustomerName(callback){
    let name = "Ragini";
    callback(name);
}
getCustomerName(show);

// nested function
function outer(outerVar){
    function inner(innervar){
        console.log(outerVar+" "+innervar);
        
    }
    inner("world");
}
outer("Hello");