# order-service
## Salvar order:

Url: http://localhost:8080/orders -> POST

### Exemplo de Body: 

{
    "fullName": "Name",
    "email": "teste@teste.com",
    "shippingAddress": "Rua teste teste",
    "items": [
        {
            "name": "Item 1",
            "price": 10.13,
            "quantity" : 2
        },
        {
            "name": "Item 2",
            "price": 20.07,
            "quantity" : 4
        }
    ],
    "paymentMode": "CREDIT_CARD",
    "status": "COMPLETED",
    "transaction": {
        "id": 1165454646464645654,
        "cardNumber": "5488888888887192",
        "expirationDate": "12/23",
        "brand": "VISA"
    }   
}

## Recuperar order:

Url: http://localhost:8080/orders/1 -> GET


## Atualizar order:

Url: http://localhost:8080/orders/1 -> PUT

### Exemplo de Body: 

{
    "fullName": "David",
    "email": "teste@teste.com",
    "shippingAddress": "Rua teste teste",
    "items": [
        {
            "name": "Item 1",
            "price": 10.13,
            "quantity" : 2
        }
    ],
    "paymentMode": "CREDIT_CARD",
    "status": "SHIPPED",
    "transaction": {
        "id": 1165454646464645654,
        "cardNumber": "5488888888887192",
        "expirationDate": "12/23",
        "brand": "VISA"
    }   
}

## Deletar order:

Url: http://localhost:8080/orders/1 -> DELETE


