const obj = {
    name:"Rohit",
    age: 20,
    course: "java"
}
console.log(obj.name);
console.log(obj.age);
console.log(obj.course);

//nested object
const student = {
    name:"Rohit",
    age: 20,
    course: "java",
    address:{
        city: "ynr",
        state: "Haryana"
    }

}
console.log(student.address.city);
console.log(student.address.state);

student.name = "Rohit Kumar"; // update in object
student.add = "added in object" // add in object
student.caste = "obc"; // add in object
console.log(student);
console.log(student.caste);// accessed added attribute in object
delete(student.add); //deleted add named attribute from object
console.log(student);

const stud = {
    name:"Rohit",
    age: 20,
    course: "java",
    address:{
        city: "ynr",
        state: "Haryana"
    },
    funInsideObj(){              // function inside object : function keyword must not use to define function inside object
        console.log("function inside method and I am "+this.name);
    },
    createMethod: function(){
        console.log("Method is created: function inside object known as method")
         
    }
    

}
console.log(stud.funInsideObj());
console.log(stud.createMethod());

Object.values(stud).forEach((v) =>{    // used to access all keys values of object
    console.log(v);
    
})




