import {useEffect, useState} from "react";
import User from "./User/User"
import {USERS} from "../const/apiConst"
import axios from "axios"
import './HomePage.css'

function HomePage() {

    const [users, setUsers] = useState([])

    const fetchData = async () => {
        await axios(
            USERS,
        ).then((resp) => {
            setUsers(resp.data);
        }).catch(setUsers([]))
    };

    useEffect(() => {
        fetchData();
    }, [])

    return (
        <div className="Users">
            <User user={users} />
        </div>
    );
}

export default HomePage;
