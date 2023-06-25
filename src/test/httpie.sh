http localhost:8080/users username=user1 password=123 role=ADMIN
http PUT localhost:8080/users/admins/1 orgName=org1

http localhost:8080/users username=user2 password=123 role=PRINCIPAL
http PUT localhost:8080/users/principals/2 taxpayerIdentificationNumber:=228

http localhost:8080/contracts adminId=1 message=please
http PUT localhost:8080/contracts/1
