import axios from "axios";
import {ADD_AGREEMENT, ADD_CUSTOMER, ADD_SERVICE} from "../../const/apiConst";
import "../HomePage.css"
import {useState} from "react";

function AddComponent(props) {

    //Customer
    const [name, setName] = useState("");
    const [idNumber, setIdNumber] = useState("");

    //Agreement
    const [customerId, setCustomerId] = useState("");
    const [agrType, setAgrType] = useState("");
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");

    //Service
    const [agreementId, setAgreementId] = useState("")
    const [serviceType, setServiceType] = useState("")
    const [serviceFee, setServiceFee] = useState("")

    const [isSuccess, setSuccess] = useState("")

    const handleAddCustomer = async (e) => {
        e.preventDefault();
        await axios.post(ADD_CUSTOMER, {
            "name": name,
            "idNumber": idNumber
        }).then(r => {
            if (r.data.id !== null) {
                setSuccess(r.data.id);
                setName("")
                setIdNumber("")
            }
        })
    }

    const handleAddAgreement = async (e) => {
        e.preventDefault();
        await axios.post(ADD_AGREEMENT, {
            "customerEntity": {
                "id": customerId
            },
            "typeAgreement": parseInt(agrType),
            "startAgreement": startDate.replace("T", " "),
            "endAgreement": endDate.replace("T", " ")
        }).then(r => {
            if (r.data.id !== null) {
                setSuccess(r.data.id);
                setCustomerId("")
                setAgrType("")
                setStartDate("")
                setEndDate("")
            }
        })
    }

    const handleAddService = async (e) => {
        e.preventDefault();
        await axios.post(ADD_SERVICE, {
            "agreementEntity": {
                "id": agreementId
            },
            "typeService": parseInt(serviceType),
            "feeService": parseInt(serviceFee)
        }).then(r => {
            if (r.data.id !== null) {
                setSuccess(r.data.id);
                setAgreementId("")
                setServiceType("")
                setServiceFee("")
            }
        })
    }
    return (
        <>
            <div className="addSection">
                <div>
                    <h3> Add customer </h3>
                    <form onSubmit={handleAddCustomer}>
                        <input required={true} name="firstName" placeholder="First name" value={name}
                               onChange={e => setName(e.target.value)} />
                        <br />
                        <input required={true} name="idNumber" placeholder="Identification number" value={idNumber}
                               onChange={e => setIdNumber(e.target.value)} />
                        <br />
                        <input type="submit" value="Submit"/>
                    </form>
                </div>
                <div className="formSection">
                    <h3> Add agreement </h3>
                    <form onSubmit={handleAddAgreement}>
                        <label>Customer id: </label>
                        <input required={true} name="customerId" placeholder="Customer id" value={customerId}
                               onChange={e => setCustomerId(e.target.value)} />
                        <br />
                        <label>Agreement type: </label>
                        <input required={true} name="type" placeholder="Agreement type" value={agrType}
                               onChange={e => setAgrType(e.target.value)} />
                        <br />
                        <label>Start date: </label>
                        <input required={true} type="datetime-local" name="start" step="1" value={startDate}
                               onChange={e => setStartDate(e.target.value)} />
                        <br />
                        <label>End date: </label>
                        <input type="datetime-local" name="end" step="1" value={endDate}
                               onChange={e => setEndDate(e.target.value)} />
                        <br />
                        <input type="submit"/>
                    </form>
                </div>
                <div className="formSection">
                    <h3> Add service </h3>
                    <form onSubmit={handleAddService}>
                        <input required={true} name="agreementId" placeholder="Agreement ID" value={agreementId}
                               onChange={e => setAgreementId(e.target.value)} />
                        <br />
                        <input required={true} name="type" placeholder="Service type" value={serviceType}
                               onChange={e => setServiceType(e.target.value)} />
                        <br />
                        <input required={true} name="fee" placeholder="Service fee" value={serviceFee}
                               onChange={e => setServiceFee(e.target.value)} />
                        <br />
                        <input type="submit" />
                    </form>
                </div>
            </div>
            <p style={{"color": "green"}}>{"Id of object added: "+isSuccess}</p>
        </>
    )
}

export default AddComponent