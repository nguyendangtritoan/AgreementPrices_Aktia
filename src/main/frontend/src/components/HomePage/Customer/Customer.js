import "./Customer.css";
import {Link} from "react-router-dom"
import axios from "axios";
import {CUSTOMERS, DELETE_CUSTOMER} from "../../const/apiConst";
import {useEffect, useState} from "react";


const Customer = props => {

    const [customers, setCustomers] = useState([])

    const fetchData = async () => {
        await axios(
            CUSTOMERS,
        ).then((resp) => {
            setCustomers(resp.data);
        }).catch(setCustomers([]))
    };

    const handleDelete = async (id, key) => {
        console.log(id, key)
        await axios.delete(DELETE_CUSTOMER+id).then(() => {
            const newList = customers.filter((customer) => customer.id !== id);
            setCustomers(newList)
        })
    }

    useEffect(() => {
        fetchData();
    }, [])

    return (
        <div className="customers">
            {customers.length !== 0 ?
                customers.map((customer, key) => (
                    <div className="customer" key={key}>
                        <p> Customer {key + 1} </p>
                        <div className="photo">{customer.name[0]}</div>
                        <div className="name">Name: {customer.name}</div>
                        <div className="idNumber">Id number: {customer.idNumber}</div>
                        <div className="id">ID: {customer.id}</div>
                        <Link to={`/agreementDetail/${customer.id}`}>
                            <button className="btn-detail">
                                AGREEMENT DETAIL
                            </button>
                        </Link>
                        <button className="btn-del" onClick={() => handleDelete(customer.id, key)}>Delete</button>
                    </div>)
                ) : <div className="agreement">
                    <div className="info">THERE IS NO CUSTOMER EXIST</div>
                </div>
            }
        </div>
    );
}

export default Customer;
