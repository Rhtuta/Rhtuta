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
*/

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
*/

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
prompt("Enter your name ");*/