import "./HomePage.css"
import {useState} from "react";
import AddComponent from "./Function/AddComponent";
import UpdateComponent from "./Function/UpdateComponent";


function HomePage() {

    return (
        <div>
            <p>***</p>
            <div className="welcome">
                <p>AGREEMENT SERVICE</p>
            </div>
            <AddComponent />
            <UpdateComponent />
        </div>
    );
}

export default HomePage;
