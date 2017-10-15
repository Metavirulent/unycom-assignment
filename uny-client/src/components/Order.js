import React, {Component} from 'react';
import {Grid, Paper, Typography, Icon, Button} from 'material-ui';
import {Link} from 'react-router-dom';
import {getOrder} from "../utils/service";
import {calculateFinalPrice} from "../utils/calculation";

class Order extends Component {

    constructor(props) {
        super(props);
        this.state = {
            order: {}
        }
    }

    componentDidMount() {
        getOrder(this.props.match.params.customerCode, this.props.match.params.orderId).then(response => {
            this.setState({
                order: response
            });
        });
    }

    render() {
        return (
            <Grid container justify="center" spacing={0}>
                <Grid item xs={10}>

                    <Link to={"/customers/" + this.props.match.params.customerCode}>
                        <Button raised style={{marginBottom: 16, marginTop: 16}}>
                            <Icon>keyboard_arrow_left</Icon> Go Back
                        </Button>
                    </Link>
                    <Typography type="headline" align="center" paragraph={true} style={{marginTop: 16}}>
                        Order
                    </Typography>

                    <Paper style={{padding: "20px"}}>
                        <Typography type="body1" component="p">
                            ID: {this.state.order.id}
                        </Typography>
                        <Typography type="body1" component="p">
                            Order Date: {this.state.order.orderDate}
                        </Typography>
                        <Typography type="body1" component="p">
                            Confirmation Date: {this.state.order.confirmationDate}
                        </Typography>
                        <Typography type="body1" component="p">
                            Completion Date: {this.state.order.completionDate}
                        </Typography>
                        <Typography type="body1" component="p">
                            Product: {this.state.order.product}
                        </Typography>
                        <Typography type="body1" component="p">
                            Original Price: {this.state.order.price}
                        </Typography>
                        <Typography type="body1" component="p">
                            Discounted Price: {calculateFinalPrice(this.state.order.price)}
                        </Typography>
                        <Typography type="body1" component="p">
                            Status: {this.state.order.status}
                        </Typography>
                    </Paper>

                </Grid>
            </Grid>
        );
    }
}

export default Order;