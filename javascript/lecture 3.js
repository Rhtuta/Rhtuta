if(null && undefined && 0 && NAN  && '' && ""){
    console.log("all parameters return false");
}
else{
    console.log("other any thing pass like integer,alpha: gives true");
}

var a = 10;
if(a<=10){
    console.log("condition is true");
}
else{
    console.log("other any thing pass like integer,alpha, condition gives true");
}

if("Rohit"){
    console.log(" like here Rohit, other any thing pass like integer,alpha: gives true");
}
else{
    console.log("false");
}


// loops 
var arr = [1,2,3,4,5];
for(var i = 0;  i<arr.length; i++){
    console.log(arr[i]);
}

//forEach is different from java for example

var arr1 = [1,2,3,4,5];
arr1.forEach(data =>{
    console.log(data);
})

//function doesnot need any returntype with function name and parameter type when it is passing in function as  parameters
// use function keyword to create function

// normal function
var a = 10;
function print(a){
    console.log(a);
    return 30;
}
var res = print(a);
console.log(res);


//in javascript function will always return a value even if we dont return anything , it will return undefined. for example

//ES5 functions
var a1 = 10;
function print1(a1){
    console.log(a1);
    //return 30;  will now return undefined
}
var res1 = print1(a1);
console.log(res1);

// function with expression

var func = function(){
    console.log("function with expression and hold variable will be treates as func name")
}
func();

//anonymous function

(function(){
    console.log("anonymous function");
})();



//ES6 function
// basic fat arrow function

var funct = ()=>{
    console.log("hello rohit");
  
}
funct();

// fat arrow with  one parameter
var funct1 = (name)=>{
    console.log("hello "+name);
  
}
funct1("Rohit Kumar");

// fat arrow with implicit return
var funct2 = ()=>"Returning in fat arrow function"
var res = funct2();
console.log(res); 

//in javascript function ES6 will also always return a value even if we dont return anything , it will return undefined. for example
