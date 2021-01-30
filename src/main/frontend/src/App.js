import HomePage from "./components/HomePage/HomePage"
import {BrowserRouter as Router, Route} from "react-router-dom"
import UserDetail from "./components/HomePage/User/UserDetail";
import Nav from './Nav';

function App() {
    return (
        <Router>
            <Nav />
            <Route exact path="/" component={HomePage} />
            <Route path="/users/:id" component={UserDetail} />
        </Router>
    );
}

export default App;
