# Unycom Assignment Project

This is an assignment project for Unycom.

## Getting Started
There are two modules: uny-service is the application's rest services and uny-client is the application's web client.
Each module has own documentation inside their folder's.
* [uny-service Documentation](https://github.com/alioktay/unycom-assignment/blob/master/uny-service/README.md)
* [uny-client Documentation](https://github.com/alioktay/unycom-assignment/blob/master/uny-client/README.md)

## Live Demo
https://uny-client.alioktay.org

## TODO
There are lots improvements which can be made for this project. Those will be implemented on the branch of 
**new-features**
- Add authorization and authentication with spring-security and JWT
- Add basic authentication for /actuator
- Create two users with different roles (ROLE_ADMIN, ROLE_USER)
- ROLE_USER is read only
- ROLE_ADMIN can add/delete/edit entities
- Improve uny-client for CRUD capabilities
- Integrate uny-client with JWT login
- Add 'not found' route with react-router