 function register(username, password){
    fetch('http://localhost:8080/register',{
    method:'POST',
    headers:{
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        username: username,
        password:password
    })}).then(res =>{
        if(res.ok){
            return res;
        }else{
            return null;
        }
    })
    .catch(error => console.log(error))
}

function consolog(){
     return "hahahah";
 }
