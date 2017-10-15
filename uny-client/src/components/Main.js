import React, {Component} from 'react';
import CustomerList from "./CustomerList";
import Customer from "./Customer";
import Order from "./Order";
import {AppBar, Toolbar, Typography, Icon} from 'material-ui';
import {BrowserRouter, Route, Link} from 'react-router-dom';

class Main extends Component {
    render() {
        return (
            <div>
                <BrowserRouter>
                    <div>
                        <AppBar position="static">
                            <Toolbar>
                                <Link to={"/"} style={{marginRight: 10}}><Icon color="accent">home</Icon></Link>
                                <Typography type="title" color="inherit"> Unycom interview assignment project
                                </Typography>
                            </Toolbar>
                        </AppBar>
                        <Route exact path="/" component={CustomerList}/>
                        <Route exact path="/customers/:code" component={Customer}/>
                        <Route exact path="/customers/:customerCode/orders/:orderId" component={Order}/>
                    </div>
                </BrowserRouter>
            </div>
        )
    };
}

export default Main;
