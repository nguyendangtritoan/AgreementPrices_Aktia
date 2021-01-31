import HomePage from "./components/HomePage/HomePage"
import {BrowserRouter as Router, Route} from "react-router-dom"
import CustomerDetail from "./components/HomePage/Customer/CustomerDetail";
import Nav from './Nav';
import Customer from "./components/HomePage/Customer/Customer";
import Agreement from "./components/HomePage/Agreement/Agreement";
import Service from "./components/HomePage/Service/Service";

function App() {
    return (
        <Router>
            <Nav />
            <Route exact path="/" component={HomePage} />
            <Route exact path="/customers" component={Customer} />
            <Route path="/agreementDetail/:id" component={CustomerDetail} />
            <Route path="/agreements" component={Agreement} />
            <Route path="/services" component={Service} />
        </Router>
    );
}

export default App;
