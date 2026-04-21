console.log(2**5); // ** operator for power

console.log(10 == "10"); // gives true, because here equal to == ignore the typeof
console.log(10 === "10"); // gives false , because here === identify the typeof

console.log(10 != "10"); // gives false, because here equal to != ignore the typeof
console.log(10 !== "10"); // gives true , because here !== identify the typeof

// Note: in js , use !== and === in place of != and ==

let fname = "Rohit Kumar";
let fage = 20;
let canVote = (fage >= 18)? "yes" : "No";
console.log(canVote);
console.log((fage >= 18)? "yes" : "No");

console.log(fname+" "+fage);
console.log(`hello ${fname} welcome to js`);// this way we can use any name as automatic change to database or print it



