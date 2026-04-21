var a;
console.log(a);//gives undefined because not initialized

var arr = [1,2,3,4,5];
console.log(arr[8]); // gives undefined because index 8 is not initialized in arr

var c = null;
console.log(c);

//console.log(b);//gives not defined because b is not defined


//object
//one way to create object
//var obj1 = new obj1()


var obj ={
    name : "Rohit",
    age : "20"
}
console.log(obj.name);
console.log(obj.age);



//array
function print() {console.log("hello");}
var arry = [1, "Rohit", arr, print(), obj ];
arry.forEach(data =>{
    console.log(data);
})


//this keyword
console.log(this);// refers window

function func(){
    console.log(this);// refers window
}
func();

//methods : that function which is inside the object known as methods

var objj = {
    name : function(){
        console.log(this );// refers object
    }
}
console.log(objj.name());

//ES5 function inside method refers window 
var objj1 = {
    parent : function(){
        function child(){
            console.log(this);//refers windows
        }
        child();

    }
}
console.log(objj1.parent());

//ES6 function inside method refers object
var objj2 = {
    parent : function(){
        var child = () =>{
            console.log(this);//refers object
        }
        child();

    }
}
console.log(objj2.parent());

//constructor : new blank object
function show(){
    console.log(this);//refers object
}
var objj3 = new show();
console.log(objj3);



//here this refers to current  listener which is here click button
document.querySelector("button")
  .addEventListener("click",function(){
    console.log(this);
  })

//change value of this using call function
var obj5 = {
    name : "call"
}
function funcc(){
    console.log(this);//function refers window but due to call we r passing obj5 so funcc will refer obj5 and object not window
    console.log(this.name);
}
funcc.call(obj5);


//change value of this using apply function and can also pass parameters in function while using apply(parameters)
var obj6 = {
    name : "apply"
}
function funcc1(a, str, arr){
    console.log(this);//function refers window but due to apply we r passing obj5 so funcc will refer obj5 and object not window
    console.log(this.name, a, str, arr);
}
funcc1.apply(obj6, [10, "hello mitr", arr]);

// 
var obj7 = {
    name : "bind"
}
function funcc2(){
    console.log(this);//function refers window but due to bind we r passing obj5 so funcc will refer obj5 and object not window
    console.log(this.name);
}
var bindInFunc = funcc2.bind(obj7);//bind with a function and store in another function
bindInFunc();


//closure: A parent function is returning its contained child function where child function is using some value of its parent 
function printtt(){
    var p = 10;
    return function showw(){
        p++;
        console.log(p);

    }
}
var holdReturnedValue = printtt();
holdReturnedValue();