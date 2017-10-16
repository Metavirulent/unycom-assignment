# uny-client

This is the application's web client

## Demo Address
https://uny-client.alioktay.org

## Getting started

### Prerequisites

You need to have node your local machine

### Build & Run
Download source code from here. Run the code below on the working directory
```
npm install
npm start
```
Now open your browser and type http://localhost:3000/

## Docker
Additionally, you can build and run this project with docker.
While building docker image you need to pass uny-service base url path as argument.

### Build & Run
```
docker build . -t alioktay/uny-client --build-arg REACT_APP_UNY_SERVICE=https://uny-service.alioktay.org
docker run -d -p 3000:80 -t alioktay/uny-client
```


## Built With
* [React](https://reactjs.org/) - Javascript Framework
* [Create React App](https://github.com/facebookincubator/create-react-app/) - ReactJs Starter
* [axios](https://github.com/axios/axios) - HTTP Clent


## Author
**Ali Oktay** - *alioktay@gmail.com* - [Github](https://github.com/alioktay)