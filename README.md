# Estética Automotiva - Backend

Projeto desenvolvido para auxiliar o amigo **Foga** na criação de um sistema para uma **estética automotiva**. Este repositório contém a **API Backend**, responsável por gerenciar as operações principais como cadastro de clientes, agendamentos e autenticação de usuários com confirmação por e-mail. O frontend foi desenvolvido separadamente por Foga.

## 🔧 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Web**
- **Spring Security**
- **MySQL**
- **JavaMailSender (Spring Email)**
- **Flyway** *(opcional, para versionamento do banco)*
- **Maven** ou **Gradle**

## 🛠 Funcionalidades Implementadas

- ✅ CRUD de Clientes
- ✅ CRUD de Agendamentos
- ✅ Relacionamento entre clientes e agendamentos
- ✅ Sistema de autenticação e login
- ✅ Confirmação de conta via e-mail
- ✅ Proteção de rotas com Spring Security
- 📅 Organização por datas e horários de agendamento
- 📂 Estrutura limpa e modular (controller, service, repository, model)

## ✉️ Confirmação por E-mail

Ao realizar o cadastro, o usuário receberá um e-mail com um link de verificação. Somente após a confirmação o login será liberado.

Tecnologia utilizada:
- `JavaMailSender`
- Token único de verificação com expiração
- Reenvio de e-mail em caso de expiração

## ⚙️ Como Executar

1. Clone o projeto:
   ```bash
   git clone https://github.com/seu-usuario/seu-repo.git
   ```

2. Configure o `application.properties`:
   ```properties
   # Banco de Dados
   spring.datasource.url=jdbc:mysql://localhost:3306/estetica
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update

   # E-mail
   spring.mail.host=smtp.seuservidordemail.com
   spring.mail.port=587
   spring.mail.username=seu_email
   spring.mail.password=sua_senha
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true
   ```

3. Suba o banco de dados MySQL localmente com o nome `estetica`.

4. Execute a aplicação:
   - Via IDE (IntelliJ, Eclipse, etc.)
   - Ou via terminal:
     ```bash
     ./mvnw spring-boot:run
     ```

## 🔗 Conexão com o Frontend

Este backend se comunica via REST API com o frontend feito por Foga, onde os usuários interagem com a interface para agendar serviços e gerenciar seus dados.

## 📁 Estrutura de Diretórios

```
src
└── main
    ├── java
    │   └── com.seuprojeto.estetica
    │       ├── controller
    │       ├── service
    │       ├── model
    │       ├── repository
    │       └── security
    └── resources
        ├── application.properties
        └── templates/email (opcional)
```

## 🤝 Colaboração

- **Backend:** Otaviano  
- **Frontend:** Foga

## 📜 Licença

Este projeto é de uso pessoal e colaborativo. Fique à vontade para sugerir melhorias ou adaptar ao seu negócio.