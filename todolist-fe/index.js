let todoLista = []

function megjelenit(){
    let lista = document.getElementById("lista")
    lista.innerHTML = ""
    todoLista.forEach(function(element) {
        let li = document.createElement("li")
        li.innerHTML = element.text
        lista.appendChild(li)
    });
}

window.addEventListener("DOMContentLoaded", function() {
    fetch("http://localhost:8080/todos")
        .then(function(response) {
            if(!response.ok){
                throw new Error("HTTP hiba: " + response.statusText)
            }
            else{
                return response.json()
            }
        })
        .then(function(eredmeny) {
            todoLista = eredmeny
            console.log(eredmeny)
            megjelenit()
        })
        .catch(function(error) {
            window.alert("HIBA!!!!: " + error.message)
        })

        document.getElementById("btn").addEventListener("click", function() {
            let todoText = document.getElementById("txt").value
            let todoItem = {
                text: todoText,
                done: false
            }
            todoLista.push(todoItem)
            megjelenit()
            fetch("http://localhost:8080/todos", {
                method: "POST",
                body: JSON.stringify(todoItem)
            })
            .then(function(response) {
                if(!response.ok){
                    throw new Error("HTTP hiba: " + response.statusText)
                }
                else{
                    return response.json()
                }
            })
            .catch(function(error) {
                window.alert("HIBA!!!!: " + error.message)
            })
        })
});

