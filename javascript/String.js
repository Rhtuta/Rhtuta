let str = "Rohit";
console.log(str);

//str[0] == k // not possible replacing characters
//console.log(str);

str = "Kumar";// will reassign possible
console.log(str);

// methods
/*
.length
toUpperCase
toLowerCase
Trim
includes
indexOf
split
slice(start,end)
*/

let num = 100// gives 100
let numToStr = String(num)// gives "100"
console.log(numToStr);
let strToNum = Number("100") //gives 100
console.log(strToNum)

console.log(Number("abc")); //gives NaN(not a number) because it not a number its a string


console.log(Boolean(null)); // gives false

console.log(Boolean("hello")); // gives true anything in quotes gives true

console.log(Boolean(""));// gives false if nothing in quotes 

console.log(Boolean(undefined)); //gives false


// mini project
let fullName = "    rOHit kuMAr    ";
console.log(fullName);

console.log(fullName.trim());

fullName = fullName.trim()

let nameSplit = (fullName.toLowerCase().split(/\s+/))
console.log(nameSplit)//split from /s means space, to String array(due to string type) into two index 0&1 ['rohit','kumar']

//uppercase first letter 

function capitalize(name){
    return (name[0].toUpperCase() + name.slice(1));
}

let fname = capitalize(nameSplit[0])
let lname = capitalize(nameSplit[1])
console.log(fname +" "+ lname);









