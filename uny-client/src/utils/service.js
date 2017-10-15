import axios from 'axios';

const BASE_URL = "http://localhost:8080";

let getCustomers = () => {
    const url = BASE_URL + "/customers";
    return axios.get(url).then(response => response.data._embedded.customers);
};

let getCustomerWithOrders = (code) => {
    const url = BASE_URL + "/customers/" + code;
    return axios.get(url).then(response => {
        return response.data;
    }).then(response => {
        return axios.get(response._links.orders.href).then(resp => {
            return {
                customer: response,
                orders: resp.data._embedded.orders
            }
        });
    });
};

let getOrder = (customerCode, orderId) => {
    const url = BASE_URL + "/customers/" + customerCode + "/orders/" + orderId;
    return axios.get(url).then(response => response.data)
};

export {getOrder, getCustomerWithOrders, getCustomers};