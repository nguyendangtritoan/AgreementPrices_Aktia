import './App.css'
import {Link} from "react-router-dom"

function Nav() {
    return (
        <nav>
            <h3>App</h3>
            <ul className="nav-links">
                <Link to='/'>
                    <li>HomePage</li>
                </Link>
                <Link to='/about'>
                    <li>About</li>
                </Link>
            </ul>
        </nav>
    )
}

export default Nav;