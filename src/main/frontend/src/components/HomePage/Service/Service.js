import "./Service.css";
import {Link} from "react-router-dom"
import axios from "axios";
import {DELETE_AGREEMENT, DELETE_SERVICE, SERVICES} from "../../const/apiConst";
import {useEffect, useState} from "react";


const Service = (props) => {

    const [services, setServices] = useState([])

    const fetchData = async () => {
        await axios(
            SERVICES,
        ).then((resp) => {
            setServices(resp.data);
        }).catch(setServices([]))
    };

    const handleDelete = async (id, key) => {
        console.log(id, key)
        await axios.delete(DELETE_SERVICE+id).then(() => {
            const newList = services.filter((service) => service.id !== id);
            setServices(newList)
        })
    }

    useEffect(() => {
        fetchData();
    }, [])

    return (
        <div className="services">
            {services.length !== 0 ?
                services.map((service, key) => (
                    <div className="service" key={key}>
                        {service !== null && <>
                            <p className="info"> Service {key + 1} </p>
                            <div className="info"> - Service id: {service.id}</div>
                            <div className="info"> - Type: {service.typeService}</div>
                            <div className="info"> - Fee: {service.feeService}</div>
                            <h3 className="ref"> - Agreement: </h3>
                            <div className="info"> Id agreement: {service.agreementEntity.id}</div>
                            <button className="btn-del" onClick={() => handleDelete(service.id, key)}>Delete</button>
                        </>}
                    </div>))
                :
                <div className="agreement">
                    <div className="info">THERE IS NO SERVICE EXIST</div>
                </div>}
        </div>
    );
}

export default Service;
