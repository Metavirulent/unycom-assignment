import React, {Component} from 'react';
import {
    Grid,
    Paper,
    Typography,
    Table,
    TableHead,
    TableRow,
    TableCell,
    TableBody,
    Button,
    Icon,
    Badge
} from 'material-ui';
import {Link} from 'react-router-dom';
import {getCustomerWithOrders} from "../utils/service";
import {calculateFinalPrice} from "../utils/calculation";

class Customer extends Component {

    constructor(props) {
        super(props);
        this.state = {
            customer: {},
            orders: []
        }
    }

    componentDidMount() {
        getCustomerWithOrders(this.props.match.params.code).then(response => {
            this.setState({
                customer: response.customer,
                orders: response.orders
            });
        });
    }

    handleClick = (event, order) => {
        this.props.history.push("/customers/" + this.state.customer.code + "/orders/" + order.id);
    };

    render() {
        return (
            <Grid container justify="center" spacing={0}>
                <Grid item xs={10}>
                    <Link to="/">
                        <Button raised style={{marginBottom: 16, marginTop: 16}}>
                            <Icon>keyboard_arrow_left</Icon> Go Back
                        </Button>
                    </Link>
                    <Typography type="headline" align="center" paragraph={true} style={{marginTop: 16}}>
                        Customer
                    </Typography>
                    <Paper style={{padding: 20}}>
                        <Typography type="body1" component="p">
                            Code: {this.state.customer.code}
                        </Typography>
                        <Typography type="body1" component="p">
                            Name: {this.state.customer.name} {this.state.customer.type === "VIP" ? <Icon color="accent">star</Icon> : ''}
                        </Typography>
                        <Typography type="body1" component="p">
                            Location: {this.state.customer.location}
                        </Typography>
                        <Typography type="body1" component="p">
                            Registration: {this.state.customer.registrationDate}
                        </Typography>
                        <Typography type="body1" component="p">
                            Type: {this.state.customer.type}
                        </Typography>
                        <Typography type="body1" component="p">
                            Is Active: {this.state.customer.active ? "true" : "false"}
                        </Typography>
                    </Paper>
                </Grid>
                <Grid item xs={10}>
                    <Typography type="headline" align="center" paragraph={true} style={{marginTop: 16}}>
                        Orders
                    </Typography>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>ID</TableCell>
                                <TableCell>Product</TableCell>
                                <TableCell>Original Price</TableCell>
                                <TableCell>Discounted Price</TableCell>
                                <TableCell>Status</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {
                                this.state.orders.map((order) => {
                                    return (
                                        <TableRow hover style={{cursor: "pointer"}}
                                                  onClick={event => this.handleClick(event, order)}
                                                  key={order.id}>
                                            <TableCell>{order.id}</TableCell>
                                            <TableCell children={order.product}/>
                                            <TableCell children={order.price}/>
                                            <TableCell children={calculateFinalPrice(order.price)}/>
                                            <TableCell children={order.status}/>
                                        </TableRow>
                                    )
                                })
                            }
                        </TableBody>
                    </Table>
                </Grid>
            </Grid>
        );
    }
}

export default Customer;