# audaz_teste

Este teste era composto por 2 cruds, em que deve-se cadastrar um operator e um fare, sendo um fare filho de um operator
e caso já haja um fare com mesmo valor para determinado operator, precisa-se validar se este fare já cadastrado tem data de crianção
superior a 6 meses ou se está desativado.

##Rotas da API

**Cadastro de operator**

>    localhost:8080/operator
    
Json exemplo

>   {"code": "operator1"}

**Recuperar lista de operators**

>   localhost:8080/operator

**Cadastro de fare**

>   localhost:8080/fare

Json exemplo

>   {"value": 4.10, "operatorCode": "operator3"}

**Recuperar lista de fares**

>   localhost:8080/fare
