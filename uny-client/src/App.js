import React, {Component} from 'react';
import Main from "./components/Main";
import { MuiThemeProvider, createMuiTheme } from 'material-ui/styles'


class App extends Component {

    render() {
        const theme = createMuiTheme();
        return (
            <MuiThemeProvider theme={theme}>
                <Main />
            </MuiThemeProvider>
        );
    }
}

export default App;
