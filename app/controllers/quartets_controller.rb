class QuartetsController < ApplicationController
  # GET /quartets
  # GET /quartets.json
  def index
    @quartets = Quartet.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @quartets }
    end
  end

  # GET /quartets/1
  # GET /quartets/1.json
  def show
    @quartet = Quartet.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @quartet }
    end
  end

  # GET /quartets/new
  # GET /quartets/new.json
  def new
    @quartet = Quartet.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @quartet }
    end
  end

  # GET /quartets/1/edit
  def edit
    @quartet = Quartet.find(params[:id])
  end

  # POST /quartets
  # POST /quartets.json
  def create
    @quartet = Quartet.new(params[:quartet])

    respond_to do |format|
      if @quartet.save
        format.html { redirect_to @quartet, notice: 'Quartet was successfully created.' }
        format.json { render json: @quartet, status: :created, location: @quartet }
      else
        format.html { render action: "new" }
        format.json { render json: @quartet.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /quartets/1
  # PUT /quartets/1.json
  def update
    @quartet = Quartet.find(params[:id])

    respond_to do |format|
      if @quartet.update_attributes(params[:quartet])
        format.html { redirect_to @quartet, notice: 'Quartet was successfully updated.' }
        format.json { head :ok }
      else
        format.html { render action: "edit" }
        format.json { render json: @quartet.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /quartets/1
  # DELETE /quartets/1.json
  def destroy
    @quartet = Quartet.find(params[:id])
    @quartet.destroy

    respond_to do |format|
      format.html { redirect_to quartets_url }
      format.json { head :ok }
    end
  end
end
