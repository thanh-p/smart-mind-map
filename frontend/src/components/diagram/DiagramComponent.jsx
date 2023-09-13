import { useEffect, useState } from "react";
import { retrieveDiagramNodeApi } from "./api/DiagramApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate, useParams } from "react-router-dom";

function DiagramComponent() {

    const {diagramId, nodeId} = useParams()
    const [children, setChildren] = useState([])
    const [diagramInfo, setDiagramInfo] = useState([])

    useEffect (() => refreshDiagram(), [])

    function refreshDiagram() {
        retrieveDiagramNodeApi(diagramId, nodeId)
        .then(response => { 
            setChildren(response.data.childNode)
            setDiagramInfo(response.data)
        })
        .catch(error => console.log(error))
    }

    return (
        <div className="container">
            <h1>{diagramInfo.title}</h1>
            <div className="d-flex flex-row">
                {children.map((child, index) => (
                    <a
                    key={child.id}
                    className="p-2 text-decoration-none"
                    href={"http://localhost:3000/diagrams/" + diagramId + "/nodes/" + child.id}
                    >{child.title}</a>
                ))}
            </div>
      </div>
    )
}

export default DiagramComponent