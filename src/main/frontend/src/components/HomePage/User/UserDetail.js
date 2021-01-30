import "./User.css";
import {USER} from "../../const/apiConst"
import {useParams} from "react-router-dom"
import {useEffect, useState} from "react"
import axios from 'axios'

const UserDetail = (props) => {

    useEffect(() => {
        fetchData();
    }, [])

    const {id} = useParams();
    const [user, setUser] = useState(null)

    const fetchData = async () => {
        const data = await axios(USER + id);
        setUser(data.data)
    }


    return (
        <div className="userDetail">
            {user !== null && <>
                <div className="info"> - Name: {user.name}</div>
                <div className="info"> - Userame: {user.username}</div>
                <div className="info"> - Email: {user.email}</div>
                <div className="info"> - Phone: {user.phone}</div>
                <div className="info"> - Company: {user.company.name}</div>
                <div className="info"> - Web: {user.website}</div>
                <ul>Address</ul>
                <li className="info"> - Street: {user.address.street}</li>
                <li className="info"> - Suite: {user.address.suite}</li>
                <li className="info"> - City: {user.address.city}</li>
                <li className="info"> - Zip: {user.address.zipcode}</li>
            </>}
        </div>

    );
}

export default UserDetail;
