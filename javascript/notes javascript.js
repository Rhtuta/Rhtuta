/*lecture2




console.log('Rohit Kumar');
var a = 20;
a = 30;
console.log("value reassingned using var",a);
var  string = "var can store any datatype";
console.log(string);
let b = 20;
b = 30;
console.log("value reassingned using let",b);
var  string1 = "let can store any datatype";
console.log(string1);
const c = 50;
const d = "Ravi";
console.log("const can also store any data type like: ",d);
console.log("we can't reassign in const",c);
console.log("there are primitive datatypes that are: string, boolean, number(i.e. int in java), Null and undefined ");
console.log("there are non primitive datatypes that are: object{}, array[], function()  ");
null;
console.log(null);
var undef;
console.log("when variable is not initialized, then it is known as undefined: ", undef);

/*in case of primitive data type if we assign first variable into second variable, then change  into first variable
does'nt change second variable
because content will copy in both separate variables, and both variables will ref at different location

for example:


var n = 10;
var m = n;

n = n+2;
console.log(n);
console.log(m);
// m value doesnot change after changing n value

/*but in case of references data type if we assign first variable into second variable, then change  into first variable 
makes changes second variable
because content location will be same in both different variables, because they are reference variables and will reference
at same location if we assign one variable containing array in another array 

for example:


var arr = [1,2,3,4,5];
var arr1 = arr;

arr.pop();
arr.push(6);
console.log(arr);
console.log(arr1);
// arr and arr1 both will change if we are changing any array due to they are ref at same array in memory


/*console.warn("mandatory * data came but other data not came in database");
console.error("not any data came in database");
window.alert("there is a alert using window.alert");
alert("there is a alert using alert ");
prompt();
prompt("Enter your name ");





lecture 3

# conditionals in javascript
--------------------------------------------------
1. if else /else if  
2. switch  
3. ternory operator  

Note: if-else executed based on true false right but let's understand some types also  
null, undefined, , 0, NAN , '', "", document.all ----> false  
baki sab ---> true  
💡

## loops in javascript

1. for loop  
2. while loop  
3. dowhile-loop  
4. foreach loop  


## functions in javascript
--------------------------------------------------

function in javascript are different from java here we don't need to give return type a  
and parameter type( we can pass anything in it)  

function print(a)  
{  
}  
print() // calling  


## note: in js we treat function as value also  

in ES5 -- we have 3 types of function  

1. function statement (normal function)  
2. function expresion:- IMP, ALWAYS TAKE CONST VARIABLE FOR HOLDING FUNCTION IN A VARIABLE , MAY BE ITS NOT IN BELOW EXAMPLE
3. anonymous functions  

in ES6 -- we can write same function in 3 types  

1. fat arrow function  
   a. basic fat arrow  
   b. fat arrow with one param  
   c. fat arrow with implicit return  

# note:- in js functions with no return is actually return undefined


1. function statement (normal function)  
--------------------------------------------------  
function print()  
{  
console.log("hello");  
}  

2. function expresion  
--------------------------------------------------  
var func = function (){  
console.log("hello");  
}  

# note: in JS we will not give name in right side, left side variable name treaded as function name  

3. anonymous functions  
--------------------------------------------------  
function (){  
console.log("hello");  
}


## a. basic fat arrow function
--------------------------------------------------
var fun = () => {  
}

## b. fat arrow with one param
--------------------------------------------------
var fun = (a) => {  PARAMETERS
💡  
}  
fun(20);  ARGUMENTS

## c. fat arrow with implicit return
--------------------------------------------------
var fun = () => "Genie Ashwani";  

var res = fun();





lecture 4

// 📘 JavaScript Full Notes (All Topics in One Place)

// 🔷 Object Creation

var obj = {};  // Object literal
var obj1 = new Object();  // Constructor syntax

var obj = {
  name: "ashwani",
  age: 25,
  email: "ashwani@gmail",
  contact: "56789087654"
};

// 🔷 this Keyword in JavaScript

// In JAVA: 'this' refers to current object instance.
// In JavaScript: 'this' value depends on context.

console.log(this); // global context (window in browser)

// 🔸 Context-wise 'this' value:

// global                => window
// function              => window (in non-strict)
// method                => the object itself
// function in method ES5 => window
// function in method ES6 => object (arrow function inherits from parent)
// constructor           => new blank object
// event listener        => the element on which event is set

// 🔷 Regular Function
function print() {
  console.log(this); // window
}
print();

// 🔷 Method (function inside object)
var obj = {
  name: function() {
    console.log(this); // obj
  },
  age: 25
};
obj.name();

// 🔷 Function inside Method (ES5)
var obj = {
  parent: function() {
    function child() {
      console.log(this); // window
    }
    child();
  }
};
obj.parent();

// 🔷 Function inside Method (ES6 - Arrow Function)
var obj = {
  name: function() {
    var child = () => {
      console.log(this); // obj
    };
    child();
  }
};
obj.name();

// 🔷 Constructor Function
function print() {
  console.log(this); // new object
}
new print();

// 🔷 Event Listener Example (in browser)
// element.addEventListener('click', function() {
//   console.log(this); // the element itself
// });

// 🔷 call(), apply(), bind()

// ✅ call()
// - Calls the function immediately
// - Arguments passed one by one
var obj = { name: "ashwani" };

function print() {
  console.log(this);
}
print.call(obj); // 'this' = obj

// ✅ apply()
// - Calls the function immediately
// - Arguments passed as array
function print(x, y, z) {
  console.log(this, x, y, z);
}
print.apply(obj, [1, 2, 3]); // 'this' = obj

// ✅ bind()
// - Returns a new function with 'this' bound
// - Does NOT invoke immediately
function print() {
  console.log(this);
}
var func = print.bind(obj);
func(); // 'this' = obj

// 🔷 Closures in JavaScript

// A closure is a function that remembers variables from its parent scope
// even after the parent has finished executing.

function print() {
  var p = 10;

  return function child() {
    console.log(p); // accesses 'p' from parent scope
  };
}

var fun = print(); // fun is now the child function
fun(); // Output: 10




lecture 5 Dom

what DOM ?
DOM stands for Document Object Model

it's a way for web browsers to represent and control HTML tags

But why we need DOM ?
in html we don't have control over tag like we want to to show or hide some detail
on click of a button
we are not able do it with html so we need to take help from DOM

what is DOM manipulation ?
page me kuch bhi change krna ya manipulate krna use kam DOM manipulation kahte ha.

change ==> access ===> reach ===> selection


How to access element ?
1. selection of element
    document.getElementById
    document.getElementsByTagName
    document.getElementsByClassName
    document.querySelector('h1')
    document.querySelector('#test')
    document.querySelector('.test')
    document.querySelector('h1')

modifying element in javascript
-------------------------------
1. textContent : will use for only text because it will not understand html tags
2. innerHTML : will use when we have to use html tags

var btn = document.querySelector("button")
btn.textContent = "Starting..."

var h1 = document.querySelector('h1')
h1.textContent = "hello"
h1.innerHTML = "<i>Helloe</i>"


How to change css of element
-------------------------------
var h1 = document.querySelector('h1');
h1.style.color = red; ----> error because js condisure it as keyword

var h1 = document.querySelector('h1');
h1.style.color = 'red';
h1.style.fontFamily = "Courier New";


how to add and remove class to element
-------------------------------
var h1 = document.querySelector('h1');
h1.classList.add('test');

var h1 = document.querySelector('h1');
h1.classList.remove('test');


creating and deleting element
-------------------------------
creating of element will be done in part = creating + adding in page

creating
-----------
var h1 = document.createElement('h1')
h1.textContent = "hello"
h1.classList.add("test")

adding
--------
document.querySelector("body").appendChild(h1)

remove
--------
var btn = document.querySelector("button")
btn.remove()


//eventListener
var buttn = document.querySelector('button1');
buttn.addEventListener('click', function(){
     console.log("hello eventListener")
})
*/
