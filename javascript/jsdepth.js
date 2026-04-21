var varname = "Rohit Kumar";// global scope
console.log(varname);

var varname = "Ravi Ranjan";
console.log(varname);      //redeclared with same varname which makes it wierd ,that's why we recommend 'let' to use in place of it

/*keyword                                   reassign                redeclared                scope
var(not recommended to use)                yes                        yes                  function
let(recommeded touse in placeof var)       yes                         No                   block
const                                      No                           NO                  block    */

//function scope
function func(){
    var a = "var in function scope";
    console.log(a);
    
}
console.log(a);// show error ouside function cant access

//block scope
{
    let x = "this is let x block scope";
    const y = "this is const y block scopeo ";
    var z = "this is var z scope";
    console.log(x); // will print
    console.log(y);// will print
    console.log(z);// will print
    
}
//console.log(x); // let will not print outside block
//console.log(y);// const will not print outside block
console.log(z);// var will print because it is function scope


// data types
let str = "Rohit"; //String
let num = 15; // number
let flag = true; //Boolean
let undef; //undefined
let age = null // null
let bgInt = 1355666465n // bigInt
let smbl = Symbol("useerId"); // symbol
console.log(smbl);


//typeof tells us type of variable,func and obj
let obj = {
    name : "hare ram",
    age : 50
}

let arr = [1,2,"hello", 'hi'];

console.log(typeof str);
console.log(typeof num);
console.log(typeof flag);
console.log(typeof undef);
console.log(typeof age); // age value null is treated as object
console.log(typeof bgInt);
console.log(typeof smbl);
console.log(typeof func);
console.log(typeof obj);
console.log(typeof arr); // it is array but its still treated as object internally in js
console.log(typeof "valueUnderQuotes" ); // treated as string because value is in string
console.log(typeof null);// null is treated as object so be careful in prog about null
