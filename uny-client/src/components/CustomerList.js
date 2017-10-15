import React, {Component} from 'react';
import {Table, TableHead, TableRow, TableCell, TableBody, Typography, Grid, Icon} from 'material-ui';
import {getCustomers} from "../utils/service";

class CustomerList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            customers: []
        }
    }

    componentDidMount() {
        getCustomers().then(response => {
            this.setState({
                customers: response
            });
        });
    }

    handleClick = (event, customer) => {
        this.props.history.push("/customers/" + customer.code);
    };

    render() {
        return (
            <Grid container justify="center" spacing={0}>
                <Grid item xs={10}>
                    <Typography type="headline" align="center" paragraph={true} style={{marginTop: 16}}>
                        Customers
                    </Typography>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell style={{width: 24}}>VIP</TableCell>
                                <TableCell style={{width: 24}}>Code</TableCell>
                                <TableCell>Name</TableCell>
                                <TableCell>Location</TableCell>
                                <TableCell>Registration Date</TableCell>
                                <TableCell>Type</TableCell>
                                <TableCell>Active</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {
                                this.state.customers.map((customer) => {
                                    return (
                                        <TableRow hover style={{cursor: "pointer"}}
                                                  onClick={event => this.handleClick(event, customer)}
                                                  key={customer.code}>
                                            <TableCell>{customer.type === "VIP" ? <Icon color="accent">star</Icon> : ''}</TableCell>
                                            <TableCell>{customer.code}</TableCell>
                                            <TableCell>{customer.name}</TableCell>
                                            <TableCell>{customer.location}</TableCell>
                                            <TableCell>{customer.registrationDate}</TableCell>
                                            <TableCell>{customer.type}</TableCell>
                                            <TableCell>{customer.active ? "true" : "false"}</TableCell>
                                        </TableRow>
                                    )
                                })
                            }
                        </TableBody>
                    </Table>
                </Grid>
            </Grid>
        )

    }
}

export default CustomerList;