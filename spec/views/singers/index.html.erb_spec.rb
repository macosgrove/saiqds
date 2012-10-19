require 'spec_helper'

describe "singers/index" do
  before(:each) do
    assign(:singers, [
      stub_model(Singer),
      stub_model(Singer)
    ])
  end

  it "renders a list of singers" do
    render
    # Run the generator again with the --webrat flag if you want to use webrat matchers
  end
end
