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
    const [agrType, setAgrType] = useState(0);
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");

    //Service
    const [agreementId, setAgreementId] = useState("")
    const [serviceType, setServiceType] = useState(0)
    const [serviceFee, setServiceFee] = useState(0)

    const [isSuccess, setSuccess] = useState("")

    const handleAddCustomer = async (e) => {
        e.preventDefault();
        await axios.post(ADD_CUSTOMER, {
            "name": name,
            "idNumber": idNumber
        }).then(r => {
            if (r.data.id !== null) {
                setSuccess("1");
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
            "typeAgreement": agrType,
            "startAgreement": startDate.replace("T", " "),
            "endAgreement": endDate.replace("T", " ")
        }).then(r => {
            if (r.data.id !== null) {
                setSuccess("1");
                setCustomerId("")
                setAgrType(0)
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
            "typeService": serviceType,
            "feeService": serviceFee
        }).then(r => {
            if (r.data.id !== null) {
                setSuccess("1");
                setAgreementId("")
                setServiceType(0)
            }
        })
    }
    return (
        <>
            <div className="addSection">
                <div>
                    <h3> Add customer </h3>
                    <form onSubmit="return false">
                        <input required name="firstName" placeholder="First name" value={name}
                               onChange={e => setName(e.target.value)} />
                        <br />
                        <input required name="idNumber" placeholder="Identification number" value={idNumber}
                               onChange={e => setIdNumber(e.target.value)} />
                        <br />
                        <input type="submit" value="Submit" onClick={e => handleAddCustomer(e)} />
                    </form>
                </div>
                <div className="formSection">
                    <h3> Add agreement </h3>
                    <form>
                        <label>Customer id: </label>
                        <input required name="customerId" placeholder="Customer id" value={customerId}
                               onChange={e => setCustomerId(e.target.value)} />
                        <br />
                        <label>Agreement type: </label>
                        <input required name="type" placeholder="Agreement type"
                               onChange={e => setAgrType(parseInt(e.target.value))} />
                        <br />
                        <label>Start date: </label>
                        <input required type="datetime-local" name="start" step="1" value={startDate}
                               onChange={e => setStartDate(e.target.value)} />
                        <br />
                        <label>End date: </label>
                        <input type="datetime-local" name="end" step="1" value={endDate}
                               onChange={e => setEndDate(e.target.value)} />
                        <br />
                        <input type="submit" onClick={e => handleAddAgreement(e)} />
                    </form>
                </div>
                <div className="formSection">
                    <h3> Add service </h3>
                    <form>
                        <input required name="agreementId" placeholder="Agreement ID" value={agreementId}
                               onChange={e => setAgreementId(e.target.value)} />
                        <br />
                        <input required name="type" placeholder="Service type"
                               onChange={e => setServiceType(parseInt(e.target.value))} />
                        <br />
                        <input required name="fee" placeholder="Service fee"
                               onChange={e => setServiceFee(parseInt(e.target.value))} />
                        <br />
                        <input type="submit" value="Submit" onClick={e => handleAddService(e)} />
                    </form>
                </div>
            </div>
            <p style={{"color": "green"}}>{isSuccess === "1" ? "Added" : ""}</p>
        </>
    )
}

export default AddComponent