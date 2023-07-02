import React, {Component} from "react";
const Id = () =>{
    const [id, setId] = React.useState("");
    return(
        <>
            <div className = "wrapper">
                <label htmlFor="id">ID:</label>
                <input id="id" />
            </div>
        </>
    );
};