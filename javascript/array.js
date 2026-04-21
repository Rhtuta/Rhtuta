const colors = ["red", "orange", "yellow", "white"];
for(let data of colors){// for of loop in js
    console.log(data);
    
}

// array methods
colors.push("green"); //add element to last: [ 'red', 'orange', 'yellow', 'white', 'green' ]
console.log(colors);


colors.pop();  // remove element from last: [ 'red', 'orange', 'yellow', 'white' ]
console.log(colors);

colors.shift();// remove first element from array: [ 'orange', 'yellow', 'white' ]
console.log(colors);

console.log(colors.indexOf("yellow")) // give index

console.log(colors.join()); // join all elements of array in string: orange,yellow,white

//console.log(colors[0]);

colors.push("pink"); 
colors.push("black"); 
colors.push("dark green"); 
colors.push("blue"); 
console.log(colors);
//[ 'orange', 'yellow', 'white', 'pink', 'black', 'dark green', 'blue' ]// current array

console.log(colors.slice(2,5)); // index 2,3,4 will be extracted index 5 will not extract[ 'white', 'pink', 'black' ]
console.log(colors);[ 'orange', 'yellow', 'white', 'pink', 'black', 'dark green', 'blue' ]


console.log(colors.splice(3,2));//start from 3 index and then remove two consecutive elements ,mean here index 3 & 4 removed
//[ 'pink', 'black' ]
console.log(colors);
//[ 'orange', 'yellow', 'white', 'dark green', 'blue' ] // current array


console.log(colors.splice(3,0,"green","black"))//at index 3 , 0 element will remove means no remove and rest will added
// here from  index 3 green and black are added 
console.log(colors);//[ 'orange', 'yellow', 'white', 'green', 'black', 'dark green', 'blue' ]


//mini project
const cart = [];

// adding in cart
cart.push("T.shirts");
cart.push("Pants");
cart.push("lowers");
cart.push("Jackets");

console.log(cart);//[ 'T.shirts', 'Pants', 'lowers', 'Jackets' ]


// showing cart  to others
for(let i = 0; i<cart.length; i++){
    console.log(i+1+". "+cart[i]);
    
}
/*
1. T.shirts
2. Pants
3. lowers
4. Jackets  */

// remove particular value from cart
cart.forEach((v) => {
    if(v === "Pants"){
        console.log(cart.splice(cart.indexOf(v),1));//[ 'Pants' ]
    }
})
console.log(cart)

// another remove
if(cart.includes("lowers")){
    console.log(cart.splice(cart.indexOf("lowers"),1));//[ 'lowers' ]
}
console.log(cart)//[ 'T.shirts', 'lowers', 'Jackets' ]//[ 'T.shirts', 'Jackets' ]







