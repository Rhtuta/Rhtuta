var varName0 = document.querySelector('h1');
varName0.textContent = "by tag name : h1 changing content";

var varName1 = document.querySelector('#test');
varName1.textContent = "by id : #test changing content"; 

var varName2 = document.querySelector('.tested');
varName2.textContent = "by class name : .tested changing content";

var varName3 = document.querySelector('button');//tag name 
//varName3.textContent = "Starting Download";

var varName4 = document.querySelector('h2');
varName4.textContent = "<i> by tag name : h2 changing content </i>";// tagname printed rather to make italic so we use innerHtml

var varName5 = document.querySelector('#TEST');// by id 
varName5.innerHTML = "<i> by tag name : h2 changing content </i>";//tag is used to make italic so we must to use innerhtml here

// applying css
//varName5.style.color = red; // without using red in single or double quotes javascript treat it as keyword and give error
varName5.style.color = "red";//now it became red using color in single or double quotes
varName5.style.fontFamily = "Courier New";

//add and remove css
varName4.classList.add('apna-css'); // change color and font as mentioned in class named apna-css in style.css file
varName4.classList.remove('apna-css');

//creating element in webpage
var heading = document.createElement('h3');
heading.textContent = 'Hello, World!';
heading.classList.add('apna-css');


//adding element in webpage
document.querySelector('body').appendChild(heading);

//deleting element in webpage
//heading.remove();// this is one way
document.querySelector('body').removeChild(heading);

//eventListener
var buttn = document.querySelector('button1');
buttn.addEventListener('click', function(){
     console.log("hello eventListener")
})




